package com.eshop.sync;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.eshop.entity.log.TbOrderLog;
import com.eshop.entity.order.TbOrder;
import com.eshop.entity.order.TbWaybillSynErr;
import com.eshop.entity.order.TbWaybillSynRecord;
import com.eshop.service.log.ITbOrderLogService;
import com.eshop.service.order.*;
import com.eshop.sync.dto.DhOrderDetailReqDTO;
import com.eshop.sync.vo.DhOrderDetailRespVO;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.stream.Collectors;

/**
 * 敦煌订单运单同步测试类
 * 主要功能：
 * 1. 处理运单同步错误记录
 * 2. 调用敦煌API验证运单信息
 * 3. 更新同步状态和记录
 */
@SpringBootTest
public class OrderSyncTest3 {

    @Resource
    private DhOrderCallService dhOrderCallService;

    @Resource
    private ITbWaybillSynRecordService iTbWaybillSynRecordService;

    @Resource
    private ITbWaybillSynErrService iTbWaybillSynErrService;

    @Resource
    private ITbOrderLogService iTbOrderLogService;


    @Resource
    private ITbWaybillSynErrServiceTest iTbWaybillSynErrServiceTest;

    /**
     * 获取上下文数据，包括：
     * - 运单同步错误列表
     * - 订单信息
     * - 店铺客户端信息
     * - 运单同步记录
     */
    private ContextVO getContextVO(){
        List<TbWaybillSynErr> waybillSynErrList = iTbWaybillSynErrServiceTest.getWaybillSynErrList();
        Set<String> orderNos = waybillSynErrList.stream().map(p -> p.getOrderNo()).collect(Collectors.toSet());
        List<TbOrder> orderList = iTbWaybillSynErrServiceTest.getOrderList(orderNos);
        //根据orderNo key 本身value 转成map
        Map<String, TbOrder> orderMap = orderList.stream()
                .collect(Collectors.toMap(
                        TbOrder::getOrderNo, // Key: orderNo
                        order -> order,       // Value: TbOrder 对象本身
                        (o1, o2) -> o1
                ));
        Set<Long> shopIds = orderList.stream().map(TbOrder::getShopId).collect(Collectors.toSet());
        Map<Long, DhAppClientDTO> appClientDTOMap = iTbWaybillSynErrServiceTest.getAppClientDTOMap(shopIds);
        List<TbWaybillSynRecord> waybillSynRecordList = iTbWaybillSynErrServiceTest.getWaybillSynRecordList(orderNos);
        Map<String, TbWaybillSynRecord> synRecordMap = waybillSynRecordList.stream()
                .collect(Collectors.toMap(
                        o -> o.getOrderNo() + "||" + o.getWaybillNo(), // Key: orderNo
                        synRecord -> synRecord,       // Value: TbOrder 对象本身
                        (o1, o2) -> o1
                ));

        ContextVO contextVO = new ContextVO();
        contextVO.setWaybillSynErrList(waybillSynErrList);
        contextVO.setOrderNos(orderNos);
        contextVO.setOrderList(orderList);
        contextVO.setOrderMap(orderMap);
        contextVO.setShopIds(shopIds);
        contextVO.setAppClientDTOMap(appClientDTOMap);
        contextVO.setWaybillSynRecordList(waybillSynRecordList);
        contextVO.setSynRecordMap(synRecordMap);
        return contextVO;
    }

    @Test
    void getAllCategoriesAndSaveToJson() throws Exception {

        ContextVO contextVO = getContextVO();
        Date date = new Date();
        List<WayBillContact> wayBillContactList = new ArrayList<>();

        List<Long> errIds = new ArrayList<>();

        extracted(contextVO, errIds, wayBillContactList);

        if (CollectionUtils.isNotEmpty(errIds)) {
            updateErr(errIds);
        }

        if (CollectionUtils.isNotEmpty(wayBillContactList)) {
            for (WayBillContact wayBillContact : wayBillContactList) {
                soutLog(wayBillContact);
                updateLog(wayBillContact, date);
                recordSyncWaybillSuc(wayBillContact, date);
            }
        }


    }

    /**
     * 打印运单同步日志
     */
    private static void soutLog(WayBillContact wayBillContact) {
        String orderNo = wayBillContact.getOrderNo();
        Long parcelNo = wayBillContact.getParcelNo();
        String waybillNo = wayBillContact.getWaybillNo();
        System.out.println("订单号：" + orderNo + ",包裹号：" + parcelNo + ",已上传运单号" + waybillNo);
    }

    /**
     * 处理运单同步
     * @param contextVO 上下文数据
     * @param errIds 需要更新的错误记录ID列表
     * @param wayBillContactList 成功同步的运单信息列表
     */
    private void extracted(ContextVO contextVO, List<Long> errIds, List<WayBillContact> wayBillContactList) throws Exception {
        // 创建CompletableFuture任务列表
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        
        for (TbWaybillSynErr tbWaybillSynErr : contextVO.waybillSynErrList) {
            Long parcelNo = tbWaybillSynErr.getParcelNo();
            String waybillNo = tbWaybillSynErr.getWaybillNo();
            String orderNo = tbWaybillSynErr.getOrderNo();
            
            // 跳过无效运单号
            if (StringUtils.isBlank(waybillNo)) {
                continue;
            }
            
            TbOrder tbOrder = contextVO.orderMap.getOrDefault(orderNo, new TbOrder());
            Long shopId = tbOrder.getShopId();
            
            // 检查是否已存在同步记录
            TbWaybillSynRecord tbWaybillSynRecord = contextVO.getSynRecordMap().get(orderNo + "||" + waybillNo);
            if (tbWaybillSynRecord != null) {
                synchronized (errIds) {
                    errIds.add(tbWaybillSynErr.getId());
                }
                continue;
            }

            // 创建异步任务
            CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                try {
                    // 获取店铺客户端信息
                    DhAppClientDTO dcDTO = contextVO.getAppClientDTOMap().get(shopId);
                    if (dcDTO == null) {
                        throw new RuntimeException("店铺客户端信息不存在，shopId: " + shopId);
                    }

                    // 构建请求参数
                    DhOrderDetailReqDTO reqDTO = new DhOrderDetailReqDTO();
                    reqDTO.setOrderNo(orderNo);

                    // 调用敦煌API获取订单详情
                    return dhOrderCallService.getOrderDetail(dcDTO, reqDTO);
                } catch (Exception e) {
                    throw new CompletionException("获取订单详情失败，orderNo: " + orderNo, e);
                }
            }).thenAccept(respVO -> {
                try {
                    // 解析API响应
                    if (respVO == null || StringUtils.isBlank(respVO.getRespBody())) {
                        throw new RuntimeException("API响应为空，orderNo: " + orderNo);
                    }

                    OrderVO orderVO = JSONObject.parseObject(respVO.getRespBody(), OrderVO.class);
                    List<OrderVO.OrderDelivery> orderDeliveryList = orderVO.getOrderDeliveryList();

                    // 验证运单信息
                    if (CollectionUtils.isNotEmpty(orderDeliveryList)) {
                        for (OrderVO.OrderDelivery orderDelivery : orderDeliveryList) {
                            String deliveryNo = orderDelivery.getDeliveryNo();
                            //输出订单号和对应的运单号
                            System.out.println("订单号：" + orderNo + ",运单号：" + deliveryNo);
                            if (deliveryNo != null && deliveryNo.equals(waybillNo)) {
                                WayBillContact contact = new WayBillContact();
                                contact.setOrderNo(orderNo);
                                contact.setParcelNo(parcelNo);
                                contact.setWaybillNo(waybillNo);
                                contact.setPlatformId(tbOrder.getPlatformId());
                                contact.setSynId(1L);
                                synchronized (wayBillContactList) {
                                    wayBillContactList.add(contact);
                                }
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new CompletionException("处理API响应失败，orderNo: " + orderNo, e);
                }
            }).exceptionally(throwable -> {
                // 记录异常信息
                System.err.println("运单同步异常: " + throwable.getMessage());
                return null;
            });

            futures.add(future);
        }

        // 等待所有异步任务完成
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }

    public void updateLog(WayBillContact wayBillContact, Date date) {
        String orderNo = wayBillContact.getOrderNo();
        Long parcelNo = wayBillContact.getParcelNo();
        String waybillNo = wayBillContact.getWaybillNo();

        String description = "声明发货记录同步，waybillNo:" + waybillNo + ",parcelNo:" + parcelNo;
        TbOrderLog vo = new TbOrderLog();
        vo.setOrderNo(orderNo);
        vo.setOperateProperty("包裹推送=>" + "Dhgate");
        vo.setDescription(description);
        vo.setOperator("sys");
        vo.setOperateTime(date);
        iTbOrderLogService.save(vo);
    }

    public void recordSyncWaybillSuc(WayBillContact wayBillContact, Date date) {
        String orderNo = wayBillContact.getOrderNo();
        Long parcelNo = wayBillContact.getParcelNo();
        String waybillNo = wayBillContact.getWaybillNo();
        TbWaybillSynRecord record = new TbWaybillSynRecord();
        record.setOrderNo(orderNo);
        record.setPlatformId(wayBillContact.getPlatformId());
        record.setWaybillNo(waybillNo);
        record.setParcelNo(parcelNo);
        record.setSynId(wayBillContact.getSynId());
        record.setSynTime(date);
        record.setSynType(Byte.parseByte("1"));
        TbWaybillSynErr synErrParam = new TbWaybillSynErr();
        synErrParam.setOrderNo(orderNo);
        synErrParam.setParcelNo(parcelNo);
        synErrParam.setWaybillNo(waybillNo);
        //删除错误日志
        updateIsDeleteByOrderNoWaybill(synErrParam);
        //保存成功日志
        iTbWaybillSynRecordService.save(record);
    }

    @Data
    public static class WayBillContact {
        private String waybillNo;
        private Long parcelNo;
        private String orderNo;
        private Long platformId;
        private Long synId;
    }

    public boolean updateIsDeleteByOrderNoWaybill(TbWaybillSynErr synErrParam) {
        // 构造更新条件
        UpdateWrapper<TbWaybillSynErr> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .eq("order_no", synErrParam.getOrderNo())   // 订单号匹配
                .eq("parcel_no", synErrParam.getParcelNo())  // 包裹号匹配
                .eq("waybill_no", synErrParam.getWaybillNo()) // 运单号匹配
                .set("is_delete", 1); // 更新 is_delete 字段为 1（已删除）

        // 执行更新
        return iTbWaybillSynErrService.update(updateWrapper);
    }

    public boolean updateErr(List<Long> errIds) {
        if (CollectionUtils.isEmpty(errIds)) {
            return false;
        }
        // 每批次处理200条数据
        int batchSize = 200;
        boolean result = true;

        // 分批处理数据
        for (int i = 0; i < errIds.size(); i += batchSize) {
            // 获取当前批次的结束索引
            int endIndex = Math.min(i + batchSize, errIds.size());
            // 获取当前批次的id列表
            List<Long> batchIds = errIds.subList(i, endIndex);

            // 构造更新条件
            UpdateWrapper<TbWaybillSynErr> updateWrapper = new UpdateWrapper<>();
            updateWrapper
                    .in("id", batchIds)   // ids匹配
                    .set("is_delete", 1); // 更新 is_delete 字段为 1（已删除）

            // 执行更新，如果有一批失败则返回false
            if (!iTbWaybillSynErrService.update(updateWrapper)) {
                result = false;
            }
        }

        return result;
    }
}

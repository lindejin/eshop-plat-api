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
import java.util.stream.Collectors;

@SpringBootTest
public class OrderSyncTest2 {

    @Resource
    private DhOrderCallService dhOrderCallService;

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbWaybillService iTbWaybillService;

    @Resource
    private ITbOrderService iTbOrderService;

    @Resource
    private ITbOrderWaybillService iTbOrderWaybillService;

    @Resource
    private ITbWaybillSynRecordService iTbWaybillSynRecordService;

    @Resource
    private ITbWaybillSynErrService iTbWaybillSynErrService;

    @Resource
    private ITbOrderLogService iTbOrderLogService;


    @Resource
    private ITbWaybillSynErrServiceTest iTbWaybillSynErrServiceTest;

    @Test
    void getAllCategoriesAndSaveToJson() throws Exception {

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
        Date date = new Date();
        List<WayBillContact> wayBillContactList = new ArrayList<>();

        List<Long> errIds = new ArrayList<>();

        for (TbWaybillSynErr tbWaybillSynErr : waybillSynErrList) {
            Long parcelNo = tbWaybillSynErr.getParcelNo();
            String waybillNo = tbWaybillSynErr.getWaybillNo();
            String orderNo = tbWaybillSynErr.getOrderNo();
            if (StringUtils.isBlank(waybillNo)) {
                continue;
            }
            TbOrder tbOrder = orderMap.getOrDefault(orderNo, new TbOrder());

            Long shopId = tbOrder.getShopId();
            TbWaybillSynRecord tbWaybillSynRecord = synRecordMap.get(orderNo + "||" + waybillNo);
            if (tbWaybillSynRecord != null) {
//                TbWaybillSynErr synErrParam = new TbWaybillSynErr();
//                synErrParam.setOrderNo(orderNo);
//                synErrParam.setParcelNo(parcelNo);
//                synErrParam.setWaybillNo(waybillNo);
                //删除错误日志
                errIds.add(tbWaybillSynErr.getId());
//                updateIsDeleteByOrderNoWaybill(synErrParam);
                continue;
            }

            DhAppClientDTO dcDTO = appClientDTOMap.get(shopId);
            DhOrderDetailReqDTO reqDTO = new DhOrderDetailReqDTO();
            reqDTO.setOrderNo(orderNo);
            DhOrderDetailRespVO respVO = dhOrderCallService.getOrderDetail(dcDTO, reqDTO);
            OrderVO orderVO = JSONObject.parseObject(respVO.getRespBody(), OrderVO.class);

            List<OrderVO.OrderDelivery> orderDeliveryList = orderVO.getOrderDeliveryList();

            if (CollectionUtils.isNotEmpty(orderDeliveryList)) {
                for (OrderVO.OrderDelivery orderDelivery : orderDeliveryList) {
                    String deliveryNo = orderDelivery.getDeliveryNo();
                    if (deliveryNo.equals(waybillNo)) {
                        WayBillContact contact = new WayBillContact();
                        contact.setOrderNo(orderNo);
                        contact.setParcelNo(parcelNo);
                        contact.setWaybillNo(waybillNo);
                        contact.setPlatformId(tbOrder.getPlatformId());
                        contact.setSynId(1L);
                        wayBillContactList.add(contact);
//                        System.out.println("订单号：" + orderNo + ",包裹号：" + parcelNo + ",已上传运单号waybillNo");
                    }
                }
            }
        }
        if (CollectionUtils.isNotEmpty(errIds)) {
            updateErr(errIds);
        }

        if (CollectionUtils.isNotEmpty(wayBillContactList)) {
            for (WayBillContact wayBillContact : wayBillContactList) {
                String orderNo = wayBillContact.getOrderNo();
                Long parcelNo = wayBillContact.getParcelNo();
                String waybillNo = wayBillContact.getWaybillNo();
                System.out.println("订单号：" + orderNo + ",包裹号：" + parcelNo + ",已上传运单号" + waybillNo);
                updateLog(wayBillContact, date);
                recordSyncWaybillSuc(wayBillContact, date);
            }
        }


    }

    public void updateLog(WayBillContact wayBillContact, Date date) {
        String orderNo = wayBillContact.getOrderNo();
        Long parcelNo = wayBillContact.getParcelNo();
        String waybillNo = wayBillContact.getWaybillNo();

        String description = "敦煌平台运单号上传成功！waybillNo:" + waybillNo + ",parcelNo:" + parcelNo;
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

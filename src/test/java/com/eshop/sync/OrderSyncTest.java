package com.eshop.sync;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.eshop.entity.config.TbShop;
import com.eshop.entity.log.TbOrderLog;
import com.eshop.entity.order.*;
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
public class OrderSyncTest {

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

    @Test
    void getAllCategoriesAndSaveToJson() throws Exception {
//        List<String> parcelNos = Arrays.asList("10000362149", "10000363003", "10000363017", "10000363016", "10000362453", "10000362993", "10000360050", "10000359177", "10000362827", "10000362885", "10000362614", "10000362867", "10000362743", "10000362895", "10000362787", "10000362527", "10000362882", "10000362972", "10000362779", "10000363220");

        List<String> parcelNos = Arrays.asList("10000363003", "10000363017", "10000363016", "10000362993", "10000362867", "10000362895", "10000362787", "10000362527", "10000362882", "10000362972", "10000363027", "10000362512", "10000362911");

        List<TbWaybill> waybillList = getTbWaybills(parcelNos);
        Date date = new Date();
        List<WayBillContact> wayBillContactList = new ArrayList<>();
        for (TbWaybill tbWaybill : waybillList) {
            Long parcelNo = tbWaybill.getParcelNo();
            String waybillNo = tbWaybill.getWaybillNo();
            if (StringUtils.isBlank(waybillNo)) {
                continue;
            }
            // List<Long> waybillIdList = waybillList.stream().map(TbWaybill::getId).collect(Collectors.toList());
            List<Long> waybillIdList = Collections.singletonList(tbWaybill.getId());
            List<TbOrderWaybill> orderWaybillList = getOrderWaybillList(waybillIdList);
            List<Long> orderIds = orderWaybillList.stream().map(TbOrderWaybill::getOrderId).collect(Collectors.toList());
            List<TbOrder> orderList = getOrderList(orderIds);

            for (TbOrder tbOrder : orderList) {
                Long shopId = tbOrder.getShopId();
                String orderNo = tbOrder.getOrderNo();
                List<TbWaybillSynRecord> waybillSynRecordList = getWaybillSynRecordList(orderNo, waybillNo);
                if (CollectionUtils.isNotEmpty(waybillSynRecordList)) {
                    TbWaybillSynErr synErrParam = new TbWaybillSynErr();
                    synErrParam.setOrderNo(orderNo);
                    synErrParam.setParcelNo(parcelNo);
                    synErrParam.setWaybillNo(waybillNo);
                    //删除错误日志
                    updateIsDeleteByOrderNoWaybill(synErrParam);
                    continue;
                }

                DhAppClientDTO dcDTO = platformAppClientUtils.getDhAppClientDTO(shopId);
                DhOrderDetailReqDTO reqDTO = new DhOrderDetailReqDTO();
                reqDTO.setOrderNo(orderNo);
                DhOrderDetailRespVO respVO = dhOrderCallService.getOrderDetail(dcDTO, reqDTO);
                OrderVO orderVO = JSONObject.parseObject(respVO.getRespBody(), OrderVO.class);

                List<OrderVO.OrderDelivery> orderDeliveryList = orderVO.getOrderDeliveryList();

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
        if (CollectionUtils.isNotEmpty(wayBillContactList)) {
            for (WayBillContact wayBillContact : wayBillContactList) {
                String orderNo = wayBillContact.getOrderNo();
                Long parcelNo = wayBillContact.getParcelNo();
                System.out.println("订单号：" + orderNo + ",包裹号：" + parcelNo + ",已上传运单号waybillNo");
                updateLog(wayBillContact,date);
                recordSyncWaybillSuc(wayBillContact,date);
            }
        }


    }

    public void updateLog(WayBillContact wayBillContact,Date date) {
        String orderNo = wayBillContact.getOrderNo();
        Long parcelNo = wayBillContact.getParcelNo();
        String waybillNo = wayBillContact.getWaybillNo();

        String description =  "敦煌平台运单号上传成功！waybillNo:" + waybillNo+",parcelNo:" + parcelNo;
        TbOrderLog vo = new TbOrderLog();
        vo.setOrderNo(orderNo);
        vo.setOperateProperty("包裹推送=>" + "Dhgate");
        vo.setDescription(description);
        vo.setOperator("sys");
        vo.setOperateTime(date);
        iTbOrderLogService.save(vo);
    }

    public void recordSyncWaybillSuc(WayBillContact wayBillContact,Date date) {
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

    {
        //订单日志
//        apiLogisticsSyncRecordService.updateLog(psDto, recordDto);
        //成功记录
//        apiLogisticsSyncRecordService.recordSyncWaybillSuc(psDto, recordDto);
    }

    private List<TbWaybillSynRecord> getWaybillSynRecordList(String orderNo, String waybillNo) {
        LambdaQueryWrapper<TbWaybillSynRecord> qw = new LambdaQueryWrapper<>();
        qw.eq(TbWaybillSynRecord::getOrderNo, orderNo);
        qw.eq(TbWaybillSynRecord::getWaybillNo, waybillNo);
        List<TbWaybillSynRecord> waybillSynRecordList = iTbWaybillSynRecordService.list(qw);
        return waybillSynRecordList;
    }

    private List<TbOrder> getOrderList(List<Long> orderIds) {
        LambdaQueryWrapper<TbOrder> qw = new LambdaQueryWrapper<>();
        qw.in(TbOrder::getId, orderIds);
        List<TbOrder> orderList = iTbOrderService.list(qw);
        return orderList;
    }

    private List<TbOrderWaybill> getOrderWaybillList(List<Long> waybillIdList) {
        LambdaQueryWrapper<TbOrderWaybill> qw = new LambdaQueryWrapper<>();
        qw.in(TbOrderWaybill::getWaybillId, waybillIdList);
        List<TbOrderWaybill> orderWaybillList = iTbOrderWaybillService.list(qw);
        return orderWaybillList;
    }

    private List<TbWaybill> getTbWaybills(List<String> parcelNos) {
        LambdaQueryWrapper<TbWaybill> qw = new LambdaQueryWrapper<>();
        qw.in(TbWaybill::getParcelNo, parcelNos);
        List<TbWaybill> waybillList = iTbWaybillService.list(qw);
        return waybillList;
    }


    private String getDetail(TbShop shopDO, String orderNo) throws Exception {
        DhAppClientDTO dcDTO = platformAppClientUtils.getDhAppClientDTO(shopDO);
        DhOrderDetailReqDTO reqDTO = new DhOrderDetailReqDTO();
        reqDTO.setOrderNo(orderNo);
        DhOrderDetailRespVO respVO = dhOrderCallService.getOrderDetail(dcDTO, reqDTO);
        return respVO.getRespBody();
    }
}

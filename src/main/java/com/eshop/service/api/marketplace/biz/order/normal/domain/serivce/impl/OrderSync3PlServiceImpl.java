package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.eshop.entity.base.PlatformOrder3plVO;
import com.eshop.entity.depot.TbProcessParcel;
import com.eshop.entity.depot.TbProcessParcelRecord;
import com.eshop.entity.order.TbOrder;
import com.eshop.entity.order.TbOrderWaybill;
import com.eshop.entity.order.TbWaybill;
import com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.OrderSync3plService;
import com.eshop.service.depot.ITbProcessParcelRecordService;
import com.eshop.service.depot.ITbProcessParcelService;
import com.eshop.service.order.ITbOrderService;
import com.eshop.service.order.ITbOrderWaybillService;
import com.eshop.service.order.ITbWaybillService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ldj
 * @date 2024/3/6 15:53
 * @Description: ...
 * @Version 1.0
 */
@Service
public class OrderSync3PlServiceImpl implements OrderSync3plService {
    @Resource
    private ITbWaybillService iTbWaybillService;
    @Resource
    private ITbProcessParcelRecordService iTbProcessParcelRecordService;
    @Resource
    private ITbProcessParcelService iTbProcessParcelService;

    @Resource
    private ITbOrderService iTbOrderService;

    @Resource
    private ITbOrderWaybillService iTbOrderWaybillService;

    @Override
    public void update3plPackageRecord(Long orderId, PlatformOrder3plVO platform3plVO) throws Exception {
        Set<Long> parcelNos = selectParcelNoByOrderIds(Arrays.asList(orderId));
        if (CollectionUtils.isEmpty(parcelNos)) {
            return;
        }
        List<TbProcessParcel> processParcels = getProcessParcelList(parcelNos);
        if (CollectionUtils.isEmpty(processParcels)) {
            return;
        }
        for (TbProcessParcel processParcel : processParcels) {
            TbProcessParcelRecord processParcelRecord = getProcessParcelRecord(processParcel.getParcelNo());
            if (Objects.isNull(processParcelRecord)) {
                //更新加工包裹记录
                TbProcessParcelRecord addRecord = new TbProcessParcelRecord();
                addRecord.setParcelNo(processParcel.getParcelNo());
                addRecord.setCollectionId(platform3plVO.getCollectionId());
                addRecord.setCollectionTime(platform3plVO.getCollectionTime());
                iTbProcessParcelRecordService.save(addRecord);
            } else {
                TbProcessParcelRecord updateRecord = new TbProcessParcelRecord();
                updateRecord.setId(processParcelRecord.getId());
                updateRecord.setCollectionId(platform3plVO.getCollectionId());
                updateRecord.setCollectionTime(platform3plVO.getCollectionTime());
                iTbProcessParcelRecordService.updateById(updateRecord);
            }
        }
    }

    private TbProcessParcelRecord getProcessParcelRecord(Long parcelNo) {
        LambdaQueryWrapper<TbProcessParcelRecord> qw = new LambdaQueryWrapper<>();
        qw.eq(TbProcessParcelRecord::getParcelNo, parcelNo);
        return iTbProcessParcelRecordService.getOne(qw);
    }

    private List<TbProcessParcel> getProcessParcelList(Set<Long> parcelNos) {
        LambdaQueryWrapper<TbProcessParcel> qw = new LambdaQueryWrapper<>();
        qw.in(TbProcessParcel::getParcelNo, parcelNos);
        return iTbProcessParcelService.list(qw);
    }

    private Set<Long> selectParcelNoByOrderIds(List<Long> orderIds) {
        List<TbOrderWaybill> owList = getOwListByOrderIds(orderIds);
        List<Long> waybillIds = owList.stream().map(TbOrderWaybill::getWaybillId).collect(Collectors.toList());
        List<TbWaybill> waybillList = getWaybillsByIds(waybillIds);

        return waybillList.stream().map(TbWaybill::getParcelNo).collect(Collectors.toSet());
    }

    private List<TbOrder> getOrderList(List<Long> orderIds) {
        LambdaQueryWrapper<TbOrder> qw = new LambdaQueryWrapper<>();
        qw.in(TbOrder::getId, orderIds);
        return iTbOrderService.list(qw);
    }

    private List<TbOrderWaybill> getOwListByWaybillIdIds(List<Long> waybillIds) {
        LambdaQueryWrapper<TbOrderWaybill> qw = new LambdaQueryWrapper<>();
        qw.in(TbOrderWaybill::getWaybillId, waybillIds);
        return iTbOrderWaybillService.list(qw);
    }

    private List<TbOrderWaybill> getOwListByOrderIds(List<Long> orderIds) {
        LambdaQueryWrapper<TbOrderWaybill> qw = new LambdaQueryWrapper<>();
        qw.in(TbOrderWaybill::getOrderId, orderIds);
        return iTbOrderWaybillService.list(qw);
    }

    private List<TbWaybill> getWaybillsByIds(List<Long> ids) {
        LambdaQueryWrapper<TbWaybill> qw = new LambdaQueryWrapper<>();
        qw.in(TbWaybill::getId, ids);
        return iTbWaybillService.list(qw);
    }

    private List<TbWaybill> getTbWaybills(List<String> parcelNos) {
        LambdaQueryWrapper<TbWaybill> qw = new LambdaQueryWrapper<>();
        qw.in(TbWaybill::getParcelNo, parcelNos);
        return iTbWaybillService.list(qw);
    }


}

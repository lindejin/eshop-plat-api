package com.eshop.service.depot.impl;

import com.eshop.entity.depot.AmsLbxShipmentRecord;
import com.eshop.mapper.depot.AmsLbxShipmentRecordMapper;
import com.eshop.service.depot.IAmsLbxShipmentRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * ams_lbx_shipment的记录表，用于记录签收时间、配送时间和完成时间 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class AmsLbxShipmentRecordServiceImpl extends ServiceImpl<AmsLbxShipmentRecordMapper, AmsLbxShipmentRecord> implements IAmsLbxShipmentRecordService {

}

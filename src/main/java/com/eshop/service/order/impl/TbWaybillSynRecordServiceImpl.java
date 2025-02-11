package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillSynRecord;
import com.eshop.mapper.order.TbWaybillSynRecordMapper;
import com.eshop.service.order.ITbWaybillSynRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单_运单同步表 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbWaybillSynRecordServiceImpl extends ServiceImpl<TbWaybillSynRecordMapper, TbWaybillSynRecord> implements ITbWaybillSynRecordService {

}

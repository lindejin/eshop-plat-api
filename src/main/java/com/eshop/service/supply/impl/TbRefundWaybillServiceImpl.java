package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbRefundWaybill;
import com.eshop.mapper.supply.TbRefundWaybillMapper;
import com.eshop.service.supply.ITbRefundWaybillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 退单,运单信息 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_supply")
@Service
public class TbRefundWaybillServiceImpl extends ServiceImpl<TbRefundWaybillMapper, TbRefundWaybill> implements ITbRefundWaybillService {

}

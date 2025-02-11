package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbOrderPayment;
import com.eshop.mapper.supply.TbOrderPaymentMapper;
import com.eshop.service.supply.ITbOrderPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采购单付款信息 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_supply")
@Service
public class TbOrderPaymentServiceImpl extends ServiceImpl<TbOrderPaymentMapper, TbOrderPayment> implements ITbOrderPaymentService {

}

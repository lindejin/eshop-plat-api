package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbRefundOrder;
import com.eshop.mapper.supply.TbRefundOrderMapper;
import com.eshop.service.supply.ITbRefundOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 退货单 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_supply")
@Service
public class TbRefundOrderServiceImpl extends ServiceImpl<TbRefundOrderMapper, TbRefundOrder> implements ITbRefundOrderService {

}

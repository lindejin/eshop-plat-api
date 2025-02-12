package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderRequestPayout;
import com.eshop.mapper.order.TbOrderRequestPayoutMapper;
import com.eshop.service.order.ITbOrderRequestPayoutService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单请款记录 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TbOrderRequestPayoutServiceImpl extends ServiceImpl<TbOrderRequestPayoutMapper, TbOrderRequestPayout> implements ITbOrderRequestPayoutService {

}

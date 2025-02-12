package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderRefunds;
import com.eshop.mapper.order.TbOrderRefundsMapper;
import com.eshop.service.order.ITbOrderRefundsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 退款订单 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TbOrderRefundsServiceImpl extends ServiceImpl<TbOrderRefundsMapper, TbOrderRefunds> implements ITbOrderRefundsService {

}

package com.eshop.service.order.impl;

import com.eshop.entity.order.TkOrderCostDetail;
import com.eshop.mapper.order.TkOrderCostDetailMapper;
import com.eshop.service.order.ITkOrderCostDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * TK订单费用明细 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TkOrderCostDetailServiceImpl extends ServiceImpl<TkOrderCostDetailMapper, TkOrderCostDetail> implements ITkOrderCostDetailService {

}

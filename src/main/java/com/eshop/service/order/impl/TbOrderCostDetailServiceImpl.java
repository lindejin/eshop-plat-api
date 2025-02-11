package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderCostDetail;
import com.eshop.mapper.order.TbOrderCostDetailMapper;
import com.eshop.service.order.ITbOrderCostDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单费用明细 (存储原始货币,根据货币类型与日期计算CNY) 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbOrderCostDetailServiceImpl extends ServiceImpl<TbOrderCostDetailMapper, TbOrderCostDetail> implements ITbOrderCostDetailService {

}

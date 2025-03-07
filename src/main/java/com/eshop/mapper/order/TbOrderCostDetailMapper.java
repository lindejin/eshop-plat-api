package com.eshop.mapper.order;

import com.eshop.entity.order.TbOrderCostDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 订单费用明细 (存储原始货币,根据货币类型与日期计算CNY) Mapper 接口
 * </p>
 *
 * @author order
 * @since 2025-03-07
 */
public interface TbOrderCostDetailMapper extends BaseMapper<TbOrderCostDetail> {

}

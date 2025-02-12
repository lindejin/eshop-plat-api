package com.eshop.service.order;

import com.eshop.entity.order.TbOrderCostDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单费用明细 (存储原始货币,根据货币类型与日期计算CNY) 服务类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 */
public interface ITbOrderCostDetailService extends IService<TbOrderCostDetail> {

}

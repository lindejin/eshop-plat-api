package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderFlowingWater;
import com.eshop.mapper.order.TbOrderFlowingWaterMapper;
import com.eshop.service.order.ITbOrderFlowingWaterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单流水 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_order")
@Service
public class TbOrderFlowingWaterServiceImpl extends ServiceImpl<TbOrderFlowingWaterMapper, TbOrderFlowingWater> implements ITbOrderFlowingWaterService {

}

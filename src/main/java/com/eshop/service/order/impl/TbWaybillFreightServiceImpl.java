package com.eshop.service.order.impl;

import com.eshop.entity.order.TbWaybillFreight;
import com.eshop.mapper.order.TbWaybillFreightMapper;
import com.eshop.service.order.ITbWaybillFreightService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 物流费用 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_order")
@Service
public class TbWaybillFreightServiceImpl extends ServiceImpl<TbWaybillFreightMapper, TbWaybillFreight> implements ITbWaybillFreightService {

}

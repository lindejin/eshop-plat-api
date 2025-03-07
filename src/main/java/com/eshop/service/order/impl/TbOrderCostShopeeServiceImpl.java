package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderCostShopee;
import com.eshop.mapper.order.TbOrderCostShopeeMapper;
import com.eshop.service.order.ITbOrderCostShopeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TbOrderCostShopeeServiceImpl extends ServiceImpl<TbOrderCostShopeeMapper, TbOrderCostShopee> implements ITbOrderCostShopeeService {

}

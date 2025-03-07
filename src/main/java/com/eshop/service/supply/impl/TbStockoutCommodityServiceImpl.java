package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbStockoutCommodity;
import com.eshop.mapper.supply.TbStockoutCommodityMapper;
import com.eshop.service.supply.ITbStockoutCommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 缺货记录 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_supply")
@Service
public class TbStockoutCommodityServiceImpl extends ServiceImpl<TbStockoutCommodityMapper, TbStockoutCommodity> implements ITbStockoutCommodityService {

}

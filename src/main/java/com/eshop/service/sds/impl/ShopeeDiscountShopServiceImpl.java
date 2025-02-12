package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeDiscountShop;
import com.eshop.mapper.sds.ShopeeDiscountShopMapper;
import com.eshop.service.sds.IShopeeDiscountShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮折扣活动-店铺关联关系表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ShopeeDiscountShopServiceImpl extends ServiceImpl<ShopeeDiscountShopMapper, ShopeeDiscountShop> implements IShopeeDiscountShopService {

}

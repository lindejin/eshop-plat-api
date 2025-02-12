package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeDiscount;
import com.eshop.mapper.sds.ShopeeDiscountMapper;
import com.eshop.service.sds.IShopeeDiscountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮-折扣活动信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ShopeeDiscountServiceImpl extends ServiceImpl<ShopeeDiscountMapper, ShopeeDiscount> implements IShopeeDiscountService {

}

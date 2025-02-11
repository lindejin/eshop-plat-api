package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeProduct;
import com.eshop.mapper.sds.ShopeeProductMapper;
import com.eshop.service.sds.IShopeeProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮商品 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class ShopeeProductServiceImpl extends ServiceImpl<ShopeeProductMapper, ShopeeProduct> implements IShopeeProductService {

}

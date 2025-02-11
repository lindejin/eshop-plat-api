package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeProductSkuAttr;
import com.eshop.mapper.sds.ShopeeProductSkuAttrMapper;
import com.eshop.service.sds.IShopeeProductSkuAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮产品SKU属性列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class ShopeeProductSkuAttrServiceImpl extends ServiceImpl<ShopeeProductSkuAttrMapper, ShopeeProductSkuAttr> implements IShopeeProductSkuAttrService {

}

package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeGlobalCategory;
import com.eshop.mapper.sds.ShopeeGlobalCategoryMapper;
import com.eshop.service.sds.IShopeeGlobalCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮全球商品类目 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ShopeeGlobalCategoryServiceImpl extends ServiceImpl<ShopeeGlobalCategoryMapper, ShopeeGlobalCategory> implements IShopeeGlobalCategoryService {

}

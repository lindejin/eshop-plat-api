package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeProductSpecsAttr;
import com.eshop.mapper.sds.ShopeeProductSpecsAttrMapper;
import com.eshop.service.sds.IShopeeProductSpecsAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模板产品规格变种属性列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class ShopeeProductSpecsAttrServiceImpl extends ServiceImpl<ShopeeProductSpecsAttrMapper, ShopeeProductSpecsAttr> implements IShopeeProductSpecsAttrService {

}

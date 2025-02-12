package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeProductAttrVal;
import com.eshop.mapper.sds.ShopeeProductAttrValMapper;
import com.eshop.service.sds.IShopeeProductAttrValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮产品属性值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ShopeeProductAttrValServiceImpl extends ServiceImpl<ShopeeProductAttrValMapper, ShopeeProductAttrVal> implements IShopeeProductAttrValService {

}

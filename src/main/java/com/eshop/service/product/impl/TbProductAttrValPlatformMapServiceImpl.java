package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductAttrValPlatformMap;
import com.eshop.mapper.product.TbProductAttrValPlatformMapMapper;
import com.eshop.service.product.ITbProductAttrValPlatformMapService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品属性值 映射平台值 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductAttrValPlatformMapServiceImpl extends ServiceImpl<TbProductAttrValPlatformMapMapper, TbProductAttrValPlatformMap> implements ITbProductAttrValPlatformMapService {

}

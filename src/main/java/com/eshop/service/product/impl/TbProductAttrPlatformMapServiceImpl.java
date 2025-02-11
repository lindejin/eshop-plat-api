package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductAttrPlatformMap;
import com.eshop.mapper.product.TbProductAttrPlatformMapMapper;
import com.eshop.service.product.ITbProductAttrPlatformMapService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品属性 映射平台值 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class TbProductAttrPlatformMapServiceImpl extends ServiceImpl<TbProductAttrPlatformMapMapper, TbProductAttrPlatformMap> implements ITbProductAttrPlatformMapService {

}

package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductAttr;
import com.eshop.mapper.product.TbProductAttrMapper;
import com.eshop.service.product.ITbProductAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品属性信息 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductAttrServiceImpl extends ServiceImpl<TbProductAttrMapper, TbProductAttr> implements ITbProductAttrService {

}

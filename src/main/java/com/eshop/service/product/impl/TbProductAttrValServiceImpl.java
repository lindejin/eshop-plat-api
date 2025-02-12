package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductAttrVal;
import com.eshop.mapper.product.TbProductAttrValMapper;
import com.eshop.service.product.ITbProductAttrValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品属性值 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductAttrValServiceImpl extends ServiceImpl<TbProductAttrValMapper, TbProductAttrVal> implements ITbProductAttrValService {

}

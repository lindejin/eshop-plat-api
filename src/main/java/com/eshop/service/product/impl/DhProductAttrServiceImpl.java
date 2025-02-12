package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductAttr;
import com.eshop.mapper.product.DhProductAttrMapper;
import com.eshop.service.product.IDhProductAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品属性列表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhProductAttrServiceImpl extends ServiceImpl<DhProductAttrMapper, DhProductAttr> implements IDhProductAttrService {

}

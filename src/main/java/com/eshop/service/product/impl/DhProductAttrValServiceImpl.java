package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductAttrVal;
import com.eshop.mapper.product.DhProductAttrValMapper;
import com.eshop.service.product.IDhProductAttrValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品属性值 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhProductAttrValServiceImpl extends ServiceImpl<DhProductAttrValMapper, DhProductAttrVal> implements IDhProductAttrValService {

}

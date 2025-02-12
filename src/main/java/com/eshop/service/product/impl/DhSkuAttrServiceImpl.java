package com.eshop.service.product.impl;

import com.eshop.entity.product.DhSkuAttr;
import com.eshop.mapper.product.DhSkuAttrMapper;
import com.eshop.service.product.IDhSkuAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品SKU属性值列表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhSkuAttrServiceImpl extends ServiceImpl<DhSkuAttrMapper, DhSkuAttr> implements IDhSkuAttrService {

}

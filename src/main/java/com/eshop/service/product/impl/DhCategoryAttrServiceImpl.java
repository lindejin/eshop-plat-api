package com.eshop.service.product.impl;

import com.eshop.entity.product.DhCategoryAttr;
import com.eshop.mapper.product.DhCategoryAttrMapper;
import com.eshop.service.product.IDhCategoryAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 类目属性 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhCategoryAttrServiceImpl extends ServiceImpl<DhCategoryAttrMapper, DhCategoryAttr> implements IDhCategoryAttrService {

}

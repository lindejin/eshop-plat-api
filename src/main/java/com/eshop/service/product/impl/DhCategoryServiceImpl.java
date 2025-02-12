package com.eshop.service.product.impl;

import com.eshop.entity.product.DhCategory;
import com.eshop.mapper.product.DhCategoryMapper;
import com.eshop.service.product.IDhCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 敦煌商品类目 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhCategoryServiceImpl extends ServiceImpl<DhCategoryMapper, DhCategory> implements IDhCategoryService {

}

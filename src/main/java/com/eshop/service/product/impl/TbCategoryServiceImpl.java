package com.eshop.service.product.impl;

import com.eshop.entity.product.TbCategory;
import com.eshop.mapper.product.TbCategoryMapper;
import com.eshop.service.product.ITbCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 类目 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbCategoryServiceImpl extends ServiceImpl<TbCategoryMapper, TbCategory> implements ITbCategoryService {

}

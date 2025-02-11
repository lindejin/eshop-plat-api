package com.eshop.service.product.impl;

import com.eshop.entity.product.AliExpressCategory;
import com.eshop.mapper.product.AliExpressCategoryMapper;
import com.eshop.service.product.IAliExpressCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通商品类目 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class AliExpressCategoryServiceImpl extends ServiceImpl<AliExpressCategoryMapper, AliExpressCategory> implements IAliExpressCategoryService {

}

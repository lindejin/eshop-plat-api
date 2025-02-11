package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProduct;
import com.eshop.mapper.product.TbProductMapper;
import com.eshop.service.product.ITbProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class TbProductServiceImpl extends ServiceImpl<TbProductMapper, TbProduct> implements ITbProductService {

}

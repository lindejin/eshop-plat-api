package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProduct;
import com.eshop.mapper.product.DhProductMapper;
import com.eshop.service.product.IDhProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 敦煌商品 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class DhProductServiceImpl extends ServiceImpl<DhProductMapper, DhProduct> implements IDhProductService {

}

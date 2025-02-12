package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductSku;
import com.eshop.mapper.product.DhProductSkuMapper;
import com.eshop.service.product.IDhProductSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品SKU列表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhProductSkuServiceImpl extends ServiceImpl<DhProductSkuMapper, DhProductSku> implements IDhProductSkuService {

}

package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductSku;
import com.eshop.mapper.product.TbProductSkuMapper;
import com.eshop.service.product.ITbProductSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品sku信息 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductSkuServiceImpl extends ServiceImpl<TbProductSkuMapper, TbProductSku> implements ITbProductSkuService {

}

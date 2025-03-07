package com.eshop.service.product.impl;

import com.eshop.entity.product.DhSkuInven;
import com.eshop.mapper.product.DhSkuInvenMapper;
import com.eshop.service.product.IDhSkuInvenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 有备货时产品sku与备货地址关联信息 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_product")
@Service
public class DhSkuInvenServiceImpl extends ServiceImpl<DhSkuInvenMapper, DhSkuInven> implements IDhSkuInvenService {

}

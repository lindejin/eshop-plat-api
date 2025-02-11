package com.eshop.service.product.impl;

import com.eshop.entity.product.DhSkuLocationPrice;
import com.eshop.mapper.product.DhSkuLocationPriceMapper;
import com.eshop.service.product.IDhSkuLocationPriceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 有备货时，每个备货地独立价格信息 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class DhSkuLocationPriceServiceImpl extends ServiceImpl<DhSkuLocationPriceMapper, DhSkuLocationPrice> implements IDhSkuLocationPriceService {

}

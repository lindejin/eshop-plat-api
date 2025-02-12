package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductSkuBar;
import com.eshop.mapper.product.TbProductSkuBarMapper;
import com.eshop.service.product.ITbProductSkuBarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品sku与第三方条码 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductSkuBarServiceImpl extends ServiceImpl<TbProductSkuBarMapper, TbProductSkuBar> implements ITbProductSkuBarService {

}

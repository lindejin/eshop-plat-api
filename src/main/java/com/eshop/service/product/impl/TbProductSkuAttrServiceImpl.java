package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductSkuAttr;
import com.eshop.mapper.product.TbProductSkuAttrMapper;
import com.eshop.service.product.ITbProductSkuAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sku属性信息 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductSkuAttrServiceImpl extends ServiceImpl<TbProductSkuAttrMapper, TbProductSkuAttr> implements ITbProductSkuAttrService {

}

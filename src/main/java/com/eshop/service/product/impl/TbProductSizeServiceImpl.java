package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductSize;
import com.eshop.mapper.product.TbProductSizeMapper;
import com.eshop.service.product.ITbProductSizeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品尺码 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductSizeServiceImpl extends ServiceImpl<TbProductSizeMapper, TbProductSize> implements ITbProductSizeService {

}

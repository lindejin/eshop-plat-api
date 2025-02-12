package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductColor;
import com.eshop.mapper.product.TbProductColorMapper;
import com.eshop.service.product.ITbProductColorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 主商品颜色 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductColorServiceImpl extends ServiceImpl<TbProductColorMapper, TbProductColor> implements ITbProductColorService {

}

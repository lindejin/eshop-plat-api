package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductClassify;
import com.eshop.mapper.product.TbProductClassifyMapper;
import com.eshop.service.product.ITbProductClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbProductClassifyServiceImpl extends ServiceImpl<TbProductClassifyMapper, TbProductClassify> implements ITbProductClassifyService {

}

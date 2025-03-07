package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductDeclare;
import com.eshop.mapper.product.TbProductDeclareMapper;
import com.eshop.service.product.ITbProductDeclareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商品申报信息 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_product")
@Service
public class TbProductDeclareServiceImpl extends ServiceImpl<TbProductDeclareMapper, TbProductDeclare> implements ITbProductDeclareService {

}

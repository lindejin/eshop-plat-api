package com.eshop.service.product.impl;

import com.eshop.entity.product.TbAttr;
import com.eshop.mapper.product.TbAttrMapper;
import com.eshop.service.product.ITbAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 主商品属性表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbAttrServiceImpl extends ServiceImpl<TbAttrMapper, TbAttr> implements ITbAttrService {

}

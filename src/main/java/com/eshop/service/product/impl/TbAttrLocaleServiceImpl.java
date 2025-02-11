package com.eshop.service.product.impl;

import com.eshop.entity.product.TbAttrLocale;
import com.eshop.mapper.product.TbAttrLocaleMapper;
import com.eshop.service.product.ITbAttrLocaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 属性语言配置表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class TbAttrLocaleServiceImpl extends ServiceImpl<TbAttrLocaleMapper, TbAttrLocale> implements ITbAttrLocaleService {

}

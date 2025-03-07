package com.eshop.service.product.impl;

import com.eshop.entity.product.TbAttrValLocale;
import com.eshop.mapper.product.TbAttrValLocaleMapper;
import com.eshop.service.product.ITbAttrValLocaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 属性值语言配置表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class TbAttrValLocaleServiceImpl extends ServiceImpl<TbAttrValLocaleMapper, TbAttrValLocale> implements ITbAttrValLocaleService {

}

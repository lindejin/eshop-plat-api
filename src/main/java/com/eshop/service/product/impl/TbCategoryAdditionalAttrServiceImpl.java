package com.eshop.service.product.impl;

import com.eshop.entity.product.TbCategoryAdditionalAttr;
import com.eshop.mapper.product.TbCategoryAdditionalAttrMapper;
import com.eshop.service.product.ITbCategoryAdditionalAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 类目附加属性 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_product")
@Service
public class TbCategoryAdditionalAttrServiceImpl extends ServiceImpl<TbCategoryAdditionalAttrMapper, TbCategoryAdditionalAttr> implements ITbCategoryAdditionalAttrService {

}

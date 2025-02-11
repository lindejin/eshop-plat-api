package com.eshop.service.product.impl;

import com.eshop.entity.product.DhCategoryAttrVal;
import com.eshop.mapper.product.DhCategoryAttrValMapper;
import com.eshop.service.product.IDhCategoryAttrValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 类目属性值	 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class DhCategoryAttrValServiceImpl extends ServiceImpl<DhCategoryAttrValMapper, DhCategoryAttrVal> implements IDhCategoryAttrValService {

}

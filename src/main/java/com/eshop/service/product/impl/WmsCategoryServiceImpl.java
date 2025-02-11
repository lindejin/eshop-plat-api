package com.eshop.service.product.impl;

import com.eshop.entity.product.WmsCategory;
import com.eshop.mapper.product.WmsCategoryMapper;
import com.eshop.service.product.IWmsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * wms类目 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class WmsCategoryServiceImpl extends ServiceImpl<WmsCategoryMapper, WmsCategory> implements IWmsCategoryService {

}

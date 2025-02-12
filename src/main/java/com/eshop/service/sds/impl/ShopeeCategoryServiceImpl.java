package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeCategory;
import com.eshop.mapper.sds.ShopeeCategoryMapper;
import com.eshop.service.sds.IShopeeCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮商品类目 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ShopeeCategoryServiceImpl extends ServiceImpl<ShopeeCategoryMapper, ShopeeCategory> implements IShopeeCategoryService {

}

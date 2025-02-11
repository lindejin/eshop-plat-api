package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TkGlobalCategory;
import com.eshop.mapper.sds.TkGlobalCategoryMapper;
import com.eshop.service.sds.ITkGlobalCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * tiktok全球商品类目 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TkGlobalCategoryServiceImpl extends ServiceImpl<TkGlobalCategoryMapper, TkGlobalCategory> implements ITkGlobalCategoryService {

}

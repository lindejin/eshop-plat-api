package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TkCategory;
import com.eshop.mapper.sds.TkCategoryMapper;
import com.eshop.service.sds.ITkCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * tiktok商品类目 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TkCategoryServiceImpl extends ServiceImpl<TkCategoryMapper, TkCategory> implements ITkCategoryService {

}

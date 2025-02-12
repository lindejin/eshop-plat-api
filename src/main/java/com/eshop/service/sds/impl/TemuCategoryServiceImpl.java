package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuCategory;
import com.eshop.mapper.sds.TemuCategoryMapper;
import com.eshop.service.sds.ITemuCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu商品类目 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemuCategoryServiceImpl extends ServiceImpl<TemuCategoryMapper, TemuCategory> implements ITemuCategoryService {

}

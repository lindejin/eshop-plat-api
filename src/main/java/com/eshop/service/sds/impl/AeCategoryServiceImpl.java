package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeCategory;
import com.eshop.mapper.sds.AeCategoryMapper;
import com.eshop.service.sds.IAeCategoryService;
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
public class AeCategoryServiceImpl extends ServiceImpl<AeCategoryMapper, AeCategory> implements IAeCategoryService {

}

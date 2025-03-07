package com.eshop.service.product.impl;

import com.eshop.entity.product.DhCategoryCommissions;
import com.eshop.mapper.product.DhCategoryCommissionsMapper;
import com.eshop.service.product.IDhCategoryCommissionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 类目佣金比例 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhCategoryCommissionsServiceImpl extends ServiceImpl<DhCategoryCommissionsMapper, DhCategoryCommissions> implements IDhCategoryCommissionsService {

}

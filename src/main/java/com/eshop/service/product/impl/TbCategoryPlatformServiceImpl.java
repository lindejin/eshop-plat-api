package com.eshop.service.product.impl;

import com.eshop.entity.product.TbCategoryPlatform;
import com.eshop.mapper.product.TbCategoryPlatformMapper;
import com.eshop.service.product.ITbCategoryPlatformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 主类目与平台类目中间表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_product")
@Service
public class TbCategoryPlatformServiceImpl extends ServiceImpl<TbCategoryPlatformMapper, TbCategoryPlatform> implements ITbCategoryPlatformService {

}

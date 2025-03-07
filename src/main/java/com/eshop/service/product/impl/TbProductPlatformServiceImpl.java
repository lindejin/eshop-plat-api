package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductPlatform;
import com.eshop.mapper.product.TbProductPlatformMapper;
import com.eshop.service.product.ITbProductPlatformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 主库&平台库中间表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_product")
@Service
public class TbProductPlatformServiceImpl extends ServiceImpl<TbProductPlatformMapper, TbProductPlatform> implements ITbProductPlatformService {

}

package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductBase;
import com.eshop.mapper.product.DhProductBaseMapper;
import com.eshop.service.product.IDhProductBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 敦煌商品基本信息 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhProductBaseServiceImpl extends ServiceImpl<DhProductBaseMapper, DhProductBase> implements IDhProductBaseService {

}

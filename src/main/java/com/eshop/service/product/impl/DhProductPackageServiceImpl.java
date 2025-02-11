package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductPackage;
import com.eshop.mapper.product.DhProductPackageMapper;
import com.eshop.service.product.IDhProductPackageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品包装信息 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class DhProductPackageServiceImpl extends ServiceImpl<DhProductPackageMapper, DhProductPackage> implements IDhProductPackageService {

}

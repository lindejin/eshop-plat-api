package com.eshop.service.collect.impl;

import com.eshop.entity.collect.ClProductPackage;
import com.eshop.mapper.collect.ClProductPackageMapper;
import com.eshop.service.collect.IClProductPackageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采集商品包装信息 服务实现类
 * </p>
 *
 * @author collect
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_collect")
@Service
public class ClProductPackageServiceImpl extends ServiceImpl<ClProductPackageMapper, ClProductPackage> implements IClProductPackageService {

}

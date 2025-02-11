package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DhTpProductPackage;
import com.eshop.mapper.sds.DhTpProductPackageMapper;
import com.eshop.service.sds.IDhTpProductPackageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品包装信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class DhTpProductPackageServiceImpl extends ServiceImpl<DhTpProductPackageMapper, DhTpProductPackage> implements IDhTpProductPackageService {

}

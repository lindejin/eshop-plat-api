package com.eshop.service.sds.impl;

import com.eshop.entity.sds.CommonTpProductPackage;
import com.eshop.mapper.sds.CommonTpProductPackageMapper;
import com.eshop.service.sds.ICommonTpProductPackageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 通用库商品模板包装信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class CommonTpProductPackageServiceImpl extends ServiceImpl<CommonTpProductPackageMapper, CommonTpProductPackage> implements ICommonTpProductPackageService {

}

package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductPackageRange;
import com.eshop.mapper.sds.ScmProductPackageRangeMapper;
import com.eshop.service.sds.IScmProductPackageRangeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链包材费区间范围 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class ScmProductPackageRangeServiceImpl extends ServiceImpl<ScmProductPackageRangeMapper, ScmProductPackageRange> implements IScmProductPackageRangeService {

}

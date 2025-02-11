package com.eshop.service.sds.impl;

import com.eshop.entity.sds.RuleProductResult;
import com.eshop.mapper.sds.RuleProductResultMapper;
import com.eshop.service.sds.IRuleProductResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 规则-结果基础信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class RuleProductResultServiceImpl extends ServiceImpl<RuleProductResultMapper, RuleProductResult> implements IRuleProductResultService {

}

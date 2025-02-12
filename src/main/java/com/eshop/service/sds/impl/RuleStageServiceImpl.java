package com.eshop.service.sds.impl;

import com.eshop.entity.sds.RuleStage;
import com.eshop.mapper.sds.RuleStageMapper;
import com.eshop.service.sds.IRuleStageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 规则-阶段表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class RuleStageServiceImpl extends ServiceImpl<RuleStageMapper, RuleStage> implements IRuleStageService {

}

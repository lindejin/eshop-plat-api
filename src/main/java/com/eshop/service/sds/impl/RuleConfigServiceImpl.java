package com.eshop.service.sds.impl;

import com.eshop.entity.sds.RuleConfig;
import com.eshop.mapper.sds.RuleConfigMapper;
import com.eshop.service.sds.IRuleConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 规则-配置表(可能多个  和阶段分项事件一对多) 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class RuleConfigServiceImpl extends ServiceImpl<RuleConfigMapper, RuleConfig> implements IRuleConfigService {

}

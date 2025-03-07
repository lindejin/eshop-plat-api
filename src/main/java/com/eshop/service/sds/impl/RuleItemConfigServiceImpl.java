package com.eshop.service.sds.impl;

import com.eshop.entity.sds.RuleItemConfig;
import com.eshop.mapper.sds.RuleItemConfigMapper;
import com.eshop.service.sds.IRuleItemConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 规则-分项条件-规则配置表(可能多个  和阶段分项事件一对多) 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class RuleItemConfigServiceImpl extends ServiceImpl<RuleItemConfigMapper, RuleItemConfig> implements IRuleItemConfigService {

}

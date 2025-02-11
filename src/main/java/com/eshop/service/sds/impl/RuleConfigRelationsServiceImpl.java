package com.eshop.service.sds.impl;

import com.eshop.entity.sds.RuleConfigRelations;
import com.eshop.mapper.sds.RuleConfigRelationsMapper;
import com.eshop.service.sds.IRuleConfigRelationsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 规则-配置表-具体配置关系表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class RuleConfigRelationsServiceImpl extends ServiceImpl<RuleConfigRelationsMapper, RuleConfigRelations> implements IRuleConfigRelationsService {

}

package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbLogisticsRule;
import com.eshop.mapper.logistics.TbLogisticsRuleMapper;
import com.eshop.service.logistics.ITbLogisticsRuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_logistics")
@Service
public class TbLogisticsRuleServiceImpl extends ServiceImpl<TbLogisticsRuleMapper, TbLogisticsRule> implements ITbLogisticsRuleService {

}

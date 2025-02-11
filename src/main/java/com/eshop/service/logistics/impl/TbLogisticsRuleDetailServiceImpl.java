package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbLogisticsRuleDetail;
import com.eshop.mapper.logistics.TbLogisticsRuleDetailMapper;
import com.eshop.service.logistics.ITbLogisticsRuleDetailService;
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
public class TbLogisticsRuleDetailServiceImpl extends ServiceImpl<TbLogisticsRuleDetailMapper, TbLogisticsRuleDetail> implements ITbLogisticsRuleDetailService {

}

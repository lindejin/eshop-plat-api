package com.eshop.service.kpi.impl;

import com.eshop.entity.kpi.KpiMember;
import com.eshop.mapper.kpi.KpiMemberMapper;
import com.eshop.service.kpi.IKpiMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 成员 服务实现类
 * </p>
 *
 * @author kpi
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_kpi")
@Service
public class KpiMemberServiceImpl extends ServiceImpl<KpiMemberMapper, KpiMember> implements IKpiMemberService {

}

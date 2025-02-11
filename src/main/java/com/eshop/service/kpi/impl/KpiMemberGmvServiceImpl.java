package com.eshop.service.kpi.impl;

import com.eshop.entity.kpi.KpiMemberGmv;
import com.eshop.mapper.kpi.KpiMemberGmvMapper;
import com.eshop.service.kpi.IKpiMemberGmvService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 成员业绩记录 服务实现类
 * </p>
 *
 * @author kpi
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_kpi")
@Service
public class KpiMemberGmvServiceImpl extends ServiceImpl<KpiMemberGmvMapper, KpiMemberGmv> implements IKpiMemberGmvService {

}

package com.eshop.service.kpi.impl;

import com.eshop.entity.kpi.KpiProjectTeam;
import com.eshop.mapper.kpi.KpiProjectTeamMapper;
import com.eshop.service.kpi.IKpiProjectTeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 项目组 服务实现类
 * </p>
 *
 * @author kpi
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_kpi")
@Service
public class KpiProjectTeamServiceImpl extends ServiceImpl<KpiProjectTeamMapper, KpiProjectTeam> implements IKpiProjectTeamService {

}

package com.eshop.service.kpi.impl;

import com.eshop.entity.kpi.KpiProjectTeamGmv;
import com.eshop.mapper.kpi.KpiProjectTeamGmvMapper;
import com.eshop.service.kpi.IKpiProjectTeamGmvService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 项目组gmv 服务实现类
 * </p>
 *
 * @author kpi
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_kpi")
@Service
public class KpiProjectTeamGmvServiceImpl extends ServiceImpl<KpiProjectTeamGmvMapper, KpiProjectTeamGmv> implements IKpiProjectTeamGmvService {

}

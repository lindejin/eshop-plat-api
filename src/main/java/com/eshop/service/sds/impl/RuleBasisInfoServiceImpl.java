package com.eshop.service.sds.impl;

import com.eshop.entity.sds.RuleBasisInfo;
import com.eshop.mapper.sds.RuleBasisInfoMapper;
import com.eshop.service.sds.IRuleBasisInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 规则-结果基础信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class RuleBasisInfoServiceImpl extends ServiceImpl<RuleBasisInfoMapper, RuleBasisInfo> implements IRuleBasisInfoService {

}

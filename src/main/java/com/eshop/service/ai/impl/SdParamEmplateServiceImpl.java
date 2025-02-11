package com.eshop.service.ai.impl;

import com.eshop.entity.ai.SdParamEmplate;
import com.eshop.mapper.ai.SdParamEmplateMapper;
import com.eshop.service.ai.ISdParamEmplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sd img2img请求参数模版 服务实现类
 * </p>
 *
 * @author ai
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_ai")
@Service
public class SdParamEmplateServiceImpl extends ServiceImpl<SdParamEmplateMapper, SdParamEmplate> implements ISdParamEmplateService {

}

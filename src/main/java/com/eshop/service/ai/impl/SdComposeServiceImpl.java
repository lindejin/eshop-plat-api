package com.eshop.service.ai.impl;

import com.eshop.entity.ai.SdCompose;
import com.eshop.mapper.ai.SdComposeMapper;
import com.eshop.service.ai.ISdComposeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * ai sd局部修改基础信息表 服务实现类
 * </p>
 *
 * @author ai
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_ai")
@Service
public class SdComposeServiceImpl extends ServiceImpl<SdComposeMapper, SdCompose> implements ISdComposeService {

}

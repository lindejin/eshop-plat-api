package com.eshop.service.config.impl;

import com.eshop.entity.config.TbPlatformApp;
import com.eshop.mapper.config.TbPlatformAppMapper;
import com.eshop.service.config.ITbPlatformAppService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 平台应用 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_config")
@Service
public class TbPlatformAppServiceImpl extends ServiceImpl<TbPlatformAppMapper, TbPlatformApp> implements ITbPlatformAppService {

}

package com.eshop.service.config.impl;

import com.eshop.entity.config.TbSysConfig;
import com.eshop.mapper.config.TbSysConfigMapper;
import com.eshop.service.config.ITbSysConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_config")
@Service
public class TbSysConfigServiceImpl extends ServiceImpl<TbSysConfigMapper, TbSysConfig> implements ITbSysConfigService {

}

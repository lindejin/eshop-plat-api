package com.eshop.service.config.impl;

import com.eshop.entity.config.TbCountry;
import com.eshop.mapper.config.TbCountryMapper;
import com.eshop.service.config.ITbCountryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 国家代码,区号 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_config")
@Service
public class TbCountryServiceImpl extends ServiceImpl<TbCountryMapper, TbCountry> implements ITbCountryService {

}

package com.eshop.service.config.impl;

import com.eshop.entity.config.TbCountryExpand;
import com.eshop.mapper.config.TbCountryExpandMapper;
import com.eshop.service.config.ITbCountryExpandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 国家代码,区号 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_config")
@Service
public class TbCountryExpandServiceImpl extends ServiceImpl<TbCountryExpandMapper, TbCountryExpand> implements ITbCountryExpandService {

}

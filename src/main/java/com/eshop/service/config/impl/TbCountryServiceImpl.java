package com.eshop.service.config.impl;

import com.eshop.entity.config.TbCountry;
import com.eshop.mapper.config.TbCountryMapper;
import com.eshop.service.config.ITbCountryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 国家代码,区号 服务实现类
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@Service
public class TbCountryServiceImpl extends ServiceImpl<TbCountryMapper, TbCountry> implements ITbCountryService {

}

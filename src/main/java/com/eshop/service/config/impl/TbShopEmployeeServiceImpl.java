package com.eshop.service.config.impl;

import com.eshop.entity.config.TbShopEmployee;
import com.eshop.mapper.config.TbShopEmployeeMapper;
import com.eshop.service.config.ITbShopEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 店铺与用户(中间表) 服务实现类
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@Service
public class TbShopEmployeeServiceImpl extends ServiceImpl<TbShopEmployeeMapper, TbShopEmployee> implements ITbShopEmployeeService {

}

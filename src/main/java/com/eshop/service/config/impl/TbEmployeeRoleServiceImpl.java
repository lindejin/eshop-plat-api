package com.eshop.service.config.impl;

import com.eshop.entity.config.TbEmployeeRole;
import com.eshop.mapper.config.TbEmployeeRoleMapper;
import com.eshop.service.config.ITbEmployeeRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 用户与角色(中间表) 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_config")
@Service
public class TbEmployeeRoleServiceImpl extends ServiceImpl<TbEmployeeRoleMapper, TbEmployeeRole> implements ITbEmployeeRoleService {

}

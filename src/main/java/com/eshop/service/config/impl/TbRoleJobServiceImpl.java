package com.eshop.service.config.impl;

import com.eshop.entity.config.TbRoleJob;
import com.eshop.mapper.config.TbRoleJobMapper;
import com.eshop.service.config.ITbRoleJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 角色岗位(中间表) 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_config")
@Service
public class TbRoleJobServiceImpl extends ServiceImpl<TbRoleJobMapper, TbRoleJob> implements ITbRoleJobService {

}

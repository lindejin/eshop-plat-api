package com.eshop.service.config.impl;

import com.eshop.entity.config.TbRoleDetail;
import com.eshop.mapper.config.TbRoleDetailMapper;
import com.eshop.service.config.ITbRoleDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 角色权限表(中间表) 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_config")
@Service
public class TbRoleDetailServiceImpl extends ServiceImpl<TbRoleDetailMapper, TbRoleDetail> implements ITbRoleDetailService {

}

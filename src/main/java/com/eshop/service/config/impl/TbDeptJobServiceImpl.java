package com.eshop.service.config.impl;

import com.eshop.entity.config.TbDeptJob;
import com.eshop.mapper.config.TbDeptJobMapper;
import com.eshop.service.config.ITbDeptJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 部门岗位(中间表) 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_config")
@Service
public class TbDeptJobServiceImpl extends ServiceImpl<TbDeptJobMapper, TbDeptJob> implements ITbDeptJobService {

}

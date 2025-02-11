package com.eshop.service.config.impl;

import com.eshop.entity.config.TbDept;
import com.eshop.mapper.config.TbDeptMapper;
import com.eshop.service.config.ITbDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_config")
@Service
public class TbDeptServiceImpl extends ServiceImpl<TbDeptMapper, TbDept> implements ITbDeptService {

}

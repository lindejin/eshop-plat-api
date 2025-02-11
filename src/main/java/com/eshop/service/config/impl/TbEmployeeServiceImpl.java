package com.eshop.service.config.impl;

import com.eshop.entity.config.TbEmployee;
import com.eshop.mapper.config.TbEmployeeMapper;
import com.eshop.service.config.ITbEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@Service
public class TbEmployeeServiceImpl extends ServiceImpl<TbEmployeeMapper, TbEmployee> implements ITbEmployeeService {

}

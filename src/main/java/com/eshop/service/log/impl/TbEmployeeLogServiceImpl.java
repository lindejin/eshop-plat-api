package com.eshop.service.log.impl;

import com.eshop.entity.log.TbEmployeeLog;
import com.eshop.mapper.log.TbEmployeeLogMapper;
import com.eshop.service.log.ITbEmployeeLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 用户日志表 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_log")
@Service
public class TbEmployeeLogServiceImpl extends ServiceImpl<TbEmployeeLogMapper, TbEmployeeLog> implements ITbEmployeeLogService {

}

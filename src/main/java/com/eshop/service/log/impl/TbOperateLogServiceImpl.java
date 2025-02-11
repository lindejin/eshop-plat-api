package com.eshop.service.log.impl;

import com.eshop.entity.log.TbOperateLog;
import com.eshop.mapper.log.TbOperateLogMapper;
import com.eshop.service.log.ITbOperateLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 操作运行日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_log")
@Service
public class TbOperateLogServiceImpl extends ServiceImpl<TbOperateLogMapper, TbOperateLog> implements ITbOperateLogService {

}

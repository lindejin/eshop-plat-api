package com.eshop.service.log.impl;

import com.eshop.entity.log.TbMessageOperationLog;
import com.eshop.mapper.log.TbMessageOperationLogMapper;
import com.eshop.service.log.ITbMessageOperationLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 消息操作日志表 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_log")
@Service
public class TbMessageOperationLogServiceImpl extends ServiceImpl<TbMessageOperationLogMapper, TbMessageOperationLog> implements ITbMessageOperationLogService {

}

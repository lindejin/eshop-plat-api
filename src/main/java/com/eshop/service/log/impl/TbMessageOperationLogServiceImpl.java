package com.eshop.service.log.impl;

import com.eshop.entity.log.TbMessageOperationLog;
import com.eshop.mapper.log.TbMessageOperationLogMapper;
import com.eshop.service.log.ITbMessageOperationLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息操作日志表 服务实现类
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@Service
public class TbMessageOperationLogServiceImpl extends ServiceImpl<TbMessageOperationLogMapper, TbMessageOperationLog> implements ITbMessageOperationLogService {

}

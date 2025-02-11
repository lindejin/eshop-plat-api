package com.eshop.service.log.impl;

import com.eshop.entity.log.TbOrderCancelErrorLog;
import com.eshop.mapper.log.TbOrderCancelErrorLogMapper;
import com.eshop.service.log.ITbOrderCancelErrorLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 取消订单操作错误日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_log")
@Service
public class TbOrderCancelErrorLogServiceImpl extends ServiceImpl<TbOrderCancelErrorLogMapper, TbOrderCancelErrorLog> implements ITbOrderCancelErrorLogService {

}

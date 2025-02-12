package com.eshop.service.log.impl;

import com.eshop.entity.log.TbOrderLog;
import com.eshop.mapper.log.TbOrderLogMapper;
import com.eshop.service.log.ITbOrderLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单运行日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_log")
@Service
public class TbOrderLogServiceImpl extends ServiceImpl<TbOrderLogMapper, TbOrderLog> implements ITbOrderLogService {

}

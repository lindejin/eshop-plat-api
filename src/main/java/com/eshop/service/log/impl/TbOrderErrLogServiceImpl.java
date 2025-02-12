package com.eshop.service.log.impl;

import com.eshop.entity.log.TbOrderErrLog;
import com.eshop.mapper.log.TbOrderErrLogMapper;
import com.eshop.service.log.ITbOrderErrLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单错误日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_log")
@Service
public class TbOrderErrLogServiceImpl extends ServiceImpl<TbOrderErrLogMapper, TbOrderErrLog> implements ITbOrderErrLogService {

}

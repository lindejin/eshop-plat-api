package com.eshop.service.log.impl;

import com.eshop.entity.log.TbOrderRespLog;
import com.eshop.mapper.log.TbOrderRespLogMapper;
import com.eshop.service.log.ITbOrderRespLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单请求日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_log")
@Service
public class TbOrderRespLogServiceImpl extends ServiceImpl<TbOrderRespLogMapper, TbOrderRespLog> implements ITbOrderRespLogService {

}

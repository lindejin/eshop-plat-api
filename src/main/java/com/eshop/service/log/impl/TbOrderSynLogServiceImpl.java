package com.eshop.service.log.impl;

import com.eshop.entity.log.TbOrderSynLog;
import com.eshop.mapper.log.TbOrderSynLogMapper;
import com.eshop.service.log.ITbOrderSynLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 订单（订单号为单位）异常运行日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_log")
@Service
public class TbOrderSynLogServiceImpl extends ServiceImpl<TbOrderSynLogMapper, TbOrderSynLog> implements ITbOrderSynLogService {

}

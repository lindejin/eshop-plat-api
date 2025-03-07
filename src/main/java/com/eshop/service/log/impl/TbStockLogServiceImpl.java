package com.eshop.service.log.impl;

import com.eshop.entity.log.TbStockLog;
import com.eshop.mapper.log.TbStockLogMapper;
import com.eshop.service.log.ITbStockLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 库存日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_log")
@Service
public class TbStockLogServiceImpl extends ServiceImpl<TbStockLogMapper, TbStockLog> implements ITbStockLogService {

}

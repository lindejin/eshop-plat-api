package com.eshop.service.log.impl;

import com.eshop.entity.log.TbCostLog;
import com.eshop.mapper.log.TbCostLogMapper;
import com.eshop.service.log.ITbCostLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 费用运行日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_log")
@Service
public class TbCostLogServiceImpl extends ServiceImpl<TbCostLogMapper, TbCostLog> implements ITbCostLogService {

}

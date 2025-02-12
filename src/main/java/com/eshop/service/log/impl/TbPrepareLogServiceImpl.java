package com.eshop.service.log.impl;

import com.eshop.entity.log.TbPrepareLog;
import com.eshop.mapper.log.TbPrepareLogMapper;
import com.eshop.service.log.ITbPrepareLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 备货单日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_log")
@Service
public class TbPrepareLogServiceImpl extends ServiceImpl<TbPrepareLogMapper, TbPrepareLog> implements ITbPrepareLogService {

}

package com.eshop.service.log.impl;

import com.eshop.entity.log.TbParcelFreightLog;
import com.eshop.mapper.log.TbParcelFreightLogMapper;
import com.eshop.service.log.ITbParcelFreightLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹运费相关日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_log")
@Service
public class TbParcelFreightLogServiceImpl extends ServiceImpl<TbParcelFreightLogMapper, TbParcelFreightLog> implements ITbParcelFreightLogService {

}

package com.eshop.service.log.impl;

import com.eshop.entity.log.TbParcelLog;
import com.eshop.mapper.log.TbParcelLogMapper;
import com.eshop.service.log.ITbParcelLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_log")
@Service
public class TbParcelLogServiceImpl extends ServiceImpl<TbParcelLogMapper, TbParcelLog> implements ITbParcelLogService {

}

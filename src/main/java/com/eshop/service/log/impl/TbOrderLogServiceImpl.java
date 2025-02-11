package com.eshop.service.log.impl;

import com.eshop.entity.log.TbOrderLog;
import com.eshop.mapper.log.TbOrderLogMapper;
import com.eshop.service.log.ITbOrderLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单运行日志 服务实现类
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@Service
public class TbOrderLogServiceImpl extends ServiceImpl<TbOrderLogMapper, TbOrderLog> implements ITbOrderLogService {

}

package com.eshop.service.log.impl;

import com.eshop.entity.log.TbOrderSynLog;
import com.eshop.mapper.log.TbOrderSynLogMapper;
import com.eshop.service.log.ITbOrderSynLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单（订单号为单位）异常运行日志 服务实现类
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@Service
public class TbOrderSynLogServiceImpl extends ServiceImpl<TbOrderSynLogMapper, TbOrderSynLog> implements ITbOrderSynLogService {

}

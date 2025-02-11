package com.eshop.service.log.impl;

import com.eshop.entity.log.TbShipmentLog;
import com.eshop.mapper.log.TbShipmentLogMapper;
import com.eshop.service.log.ITbShipmentLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 预报（订单号为单位）异常运行日志 服务实现类
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@Service
public class TbShipmentLogServiceImpl extends ServiceImpl<TbShipmentLogMapper, TbShipmentLog> implements ITbShipmentLogService {

}

package com.eshop.service.log.impl;

import com.eshop.entity.log.TbCustomerOperationLog;
import com.eshop.mapper.log.TbCustomerOperationLogMapper;
import com.eshop.service.log.ITbCustomerOperationLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户操作日志表 服务实现类
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@Service
public class TbCustomerOperationLogServiceImpl extends ServiceImpl<TbCustomerOperationLogMapper, TbCustomerOperationLog> implements ITbCustomerOperationLogService {

}

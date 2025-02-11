package com.eshop.service.log.impl;

import com.eshop.entity.log.TbCustomerOperationLog;
import com.eshop.mapper.log.TbCustomerOperationLogMapper;
import com.eshop.service.log.ITbCustomerOperationLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 客户操作日志表 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_log")
@Service
public class TbCustomerOperationLogServiceImpl extends ServiceImpl<TbCustomerOperationLogMapper, TbCustomerOperationLog> implements ITbCustomerOperationLogService {

}

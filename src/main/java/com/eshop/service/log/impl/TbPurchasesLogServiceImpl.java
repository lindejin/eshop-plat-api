package com.eshop.service.log.impl;

import com.eshop.entity.log.TbPurchasesLog;
import com.eshop.mapper.log.TbPurchasesLogMapper;
import com.eshop.service.log.ITbPurchasesLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采购单日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_log")
@Service
public class TbPurchasesLogServiceImpl extends ServiceImpl<TbPurchasesLogMapper, TbPurchasesLog> implements ITbPurchasesLogService {

}

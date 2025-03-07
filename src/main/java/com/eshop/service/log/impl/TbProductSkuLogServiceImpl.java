package com.eshop.service.log.impl;

import com.eshop.entity.log.TbProductSkuLog;
import com.eshop.mapper.log.TbProductSkuLogMapper;
import com.eshop.service.log.ITbProductSkuLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * SKU操作日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_log")
@Service
public class TbProductSkuLogServiceImpl extends ServiceImpl<TbProductSkuLogMapper, TbProductSkuLog> implements ITbProductSkuLogService {

}

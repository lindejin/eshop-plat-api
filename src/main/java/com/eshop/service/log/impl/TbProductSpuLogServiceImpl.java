package com.eshop.service.log.impl;

import com.eshop.entity.log.TbProductSpuLog;
import com.eshop.mapper.log.TbProductSpuLogMapper;
import com.eshop.service.log.ITbProductSpuLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * SPU操作日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_log")
@Service
public class TbProductSpuLogServiceImpl extends ServiceImpl<TbProductSpuLogMapper, TbProductSpuLog> implements ITbProductSpuLogService {

}

package com.eshop.service.log.impl;

import com.eshop.entity.log.TbPublishLog;
import com.eshop.mapper.log.TbPublishLogMapper;
import com.eshop.service.log.ITbPublishLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 刊登记录 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_log")
@Service
public class TbPublishLogServiceImpl extends ServiceImpl<TbPublishLogMapper, TbPublishLog> implements ITbPublishLogService {

}

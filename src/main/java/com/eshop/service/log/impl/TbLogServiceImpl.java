package com.eshop.service.log.impl;

import com.eshop.entity.log.TbLog;
import com.eshop.mapper.log.TbLogMapper;
import com.eshop.service.log.ITbLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author log
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_log")
@Service
public class TbLogServiceImpl extends ServiceImpl<TbLogMapper, TbLog> implements ITbLogService {

}

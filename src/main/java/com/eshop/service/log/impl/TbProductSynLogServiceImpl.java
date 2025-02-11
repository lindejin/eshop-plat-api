package com.eshop.service.log.impl;

import com.eshop.entity.log.TbProductSynLog;
import com.eshop.mapper.log.TbProductSynLogMapper;
import com.eshop.service.log.ITbProductSynLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 第三方商品同步日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_log")
@Service
public class TbProductSynLogServiceImpl extends ServiceImpl<TbProductSynLogMapper, TbProductSynLog> implements ITbProductSynLogService {

}

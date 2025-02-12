package com.eshop.service.config.impl;

import com.eshop.entity.config.TbMessageReadStatus;
import com.eshop.mapper.config.TbMessageReadStatusMapper;
import com.eshop.service.config.ITbMessageReadStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 用户消息读取状态 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_config")
@Service
public class TbMessageReadStatusServiceImpl extends ServiceImpl<TbMessageReadStatusMapper, TbMessageReadStatus> implements ITbMessageReadStatusService {

}

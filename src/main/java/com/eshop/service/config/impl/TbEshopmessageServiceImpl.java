package com.eshop.service.config.impl;

import com.eshop.entity.config.TbEshopmessage;
import com.eshop.mapper.config.TbEshopmessageMapper;
import com.eshop.service.config.ITbEshopmessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 平台内部消息 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_config")
@Service
public class TbEshopmessageServiceImpl extends ServiceImpl<TbEshopmessageMapper, TbEshopmessage> implements ITbEshopmessageService {

}

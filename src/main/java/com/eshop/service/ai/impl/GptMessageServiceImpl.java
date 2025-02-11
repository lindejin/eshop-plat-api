package com.eshop.service.ai.impl;

import com.eshop.entity.ai.GptMessage;
import com.eshop.mapper.ai.GptMessageMapper;
import com.eshop.service.ai.IGptMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ai
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_ai")
@Service
public class GptMessageServiceImpl extends ServiceImpl<GptMessageMapper, GptMessage> implements IGptMessageService {

}

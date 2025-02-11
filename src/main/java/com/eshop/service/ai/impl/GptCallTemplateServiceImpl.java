package com.eshop.service.ai.impl;

import com.eshop.entity.ai.GptCallTemplate;
import com.eshop.mapper.ai.GptCallTemplateMapper;
import com.eshop.service.ai.IGptCallTemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * gpt调用模板 服务实现类
 * </p>
 *
 * @author ai
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_ai")
@Service
public class GptCallTemplateServiceImpl extends ServiceImpl<GptCallTemplateMapper, GptCallTemplate> implements IGptCallTemplateService {

}

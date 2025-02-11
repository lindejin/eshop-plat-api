package com.eshop.service.ai.impl;

import com.eshop.entity.ai.GptSceneClassify;
import com.eshop.mapper.ai.GptSceneClassifyMapper;
import com.eshop.service.ai.IGptSceneClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * gpt调用场景分类 服务实现类
 * </p>
 *
 * @author ai
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_ai")
@Service
public class GptSceneClassifyServiceImpl extends ServiceImpl<GptSceneClassifyMapper, GptSceneClassify> implements IGptSceneClassifyService {

}

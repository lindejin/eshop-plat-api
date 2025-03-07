package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplateVideo;
import com.eshop.mapper.sds.TemplateVideoMapper;
import com.eshop.service.sds.ITemplateVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模版视频列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TemplateVideoServiceImpl extends ServiceImpl<TemplateVideoMapper, TemplateVideo> implements ITemplateVideoService {

}

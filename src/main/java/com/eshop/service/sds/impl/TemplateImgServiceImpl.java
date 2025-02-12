package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplateImg;
import com.eshop.mapper.sds.TemplateImgMapper;
import com.eshop.service.sds.ITemplateImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模版图片列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemplateImgServiceImpl extends ServiceImpl<TemplateImgMapper, TemplateImg> implements ITemplateImgService {

}

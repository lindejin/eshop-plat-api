package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplateAttr;
import com.eshop.mapper.sds.TemplateAttrMapper;
import com.eshop.service.sds.ITemplateAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模版产品属性列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TemplateAttrServiceImpl extends ServiceImpl<TemplateAttrMapper, TemplateAttr> implements ITemplateAttrService {

}

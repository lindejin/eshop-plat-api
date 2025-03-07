package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplateSpecsAttr;
import com.eshop.mapper.sds.TemplateSpecsAttrMapper;
import com.eshop.service.sds.ITemplateSpecsAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模板产品规格变种属性列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TemplateSpecsAttrServiceImpl extends ServiceImpl<TemplateSpecsAttrMapper, TemplateSpecsAttr> implements ITemplateSpecsAttrService {

}

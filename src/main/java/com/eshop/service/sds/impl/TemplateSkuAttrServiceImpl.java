package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplateSkuAttr;
import com.eshop.mapper.sds.TemplateSkuAttrMapper;
import com.eshop.service.sds.ITemplateSkuAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模版产品-规格变种属性列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemplateSkuAttrServiceImpl extends ServiceImpl<TemplateSkuAttrMapper, TemplateSkuAttr> implements ITemplateSkuAttrService {

}

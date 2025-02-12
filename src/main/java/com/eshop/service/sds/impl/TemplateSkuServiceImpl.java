package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplateSku;
import com.eshop.mapper.sds.TemplateSkuMapper;
import com.eshop.service.sds.ITemplateSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模板产品SKU列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemplateSkuServiceImpl extends ServiceImpl<TemplateSkuMapper, TemplateSku> implements ITemplateSkuService {

}

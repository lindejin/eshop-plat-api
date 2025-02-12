package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplateProduct;
import com.eshop.mapper.sds.TemplateProductMapper;
import com.eshop.service.sds.ITemplateProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模版基础信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemplateProductServiceImpl extends ServiceImpl<TemplateProductMapper, TemplateProduct> implements ITemplateProductService {

}

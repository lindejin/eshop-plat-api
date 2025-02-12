package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductTemplate;
import com.eshop.mapper.product.DhProductTemplateMapper;
import com.eshop.service.product.IDhProductTemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 敦煌商品导入数据(原始) 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhProductTemplateServiceImpl extends ServiceImpl<DhProductTemplateMapper, DhProductTemplate> implements IDhProductTemplateService {

}

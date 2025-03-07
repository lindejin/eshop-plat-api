package com.eshop.service.product.impl;

import com.eshop.entity.product.TbProductTemplate;
import com.eshop.mapper.product.TbProductTemplateMapper;
import com.eshop.service.product.ITbProductTemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 主库产品模版关系 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_product")
@Service
public class TbProductTemplateServiceImpl extends ServiceImpl<TbProductTemplateMapper, TbProductTemplate> implements ITbProductTemplateService {

}

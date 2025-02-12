package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplateWholesale;
import com.eshop.mapper.sds.TemplateWholesaleMapper;
import com.eshop.service.sds.ITemplateWholesaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模版批发 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemplateWholesaleServiceImpl extends ServiceImpl<TemplateWholesaleMapper, TemplateWholesale> implements ITemplateWholesaleService {

}

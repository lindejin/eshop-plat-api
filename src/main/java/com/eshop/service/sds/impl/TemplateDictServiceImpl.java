package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplateDict;
import com.eshop.mapper.sds.TemplateDictMapper;
import com.eshop.service.sds.ITemplateDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模板-数据字典 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TemplateDictServiceImpl extends ServiceImpl<TemplateDictMapper, TemplateDict> implements ITemplateDictService {

}

package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemplateDictDetail;
import com.eshop.mapper.sds.TemplateDictDetailMapper;
import com.eshop.service.sds.ITemplateDictDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模板-数据字典详情 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TemplateDictDetailServiceImpl extends ServiceImpl<TemplateDictDetailMapper, TemplateDictDetail> implements ITemplateDictDetailService {

}

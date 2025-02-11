package com.eshop.service.ai.impl;

import com.eshop.entity.ai.SdBgAttr;
import com.eshop.mapper.ai.SdBgAttrMapper;
import com.eshop.service.ai.ISdBgAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sd 背景属性 服务实现类
 * </p>
 *
 * @author ai
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_ai")
@Service
public class SdBgAttrServiceImpl extends ServiceImpl<SdBgAttrMapper, SdBgAttr> implements ISdBgAttrService {

}

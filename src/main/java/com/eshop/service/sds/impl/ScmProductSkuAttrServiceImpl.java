package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductSkuAttr;
import com.eshop.mapper.sds.ScmProductSkuAttrMapper;
import com.eshop.service.sds.IScmProductSkuAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链商品sku属性 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ScmProductSkuAttrServiceImpl extends ServiceImpl<ScmProductSkuAttrMapper, ScmProductSkuAttr> implements IScmProductSkuAttrService {

}

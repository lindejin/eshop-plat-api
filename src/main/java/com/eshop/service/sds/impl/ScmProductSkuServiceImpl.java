package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductSku;
import com.eshop.mapper.sds.ScmProductSkuMapper;
import com.eshop.service.sds.IScmProductSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链商品sku 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class ScmProductSkuServiceImpl extends ServiceImpl<ScmProductSkuMapper, ScmProductSku> implements IScmProductSkuService {

}

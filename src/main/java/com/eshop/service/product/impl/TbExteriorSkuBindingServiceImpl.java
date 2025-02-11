package com.eshop.service.product.impl;

import com.eshop.entity.product.TbExteriorSkuBinding;
import com.eshop.mapper.product.TbExteriorSkuBindingMapper;
import com.eshop.service.product.ITbExteriorSkuBindingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 第三方sku绑定信息表 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class TbExteriorSkuBindingServiceImpl extends ServiceImpl<TbExteriorSkuBindingMapper, TbExteriorSkuBinding> implements ITbExteriorSkuBindingService {

}

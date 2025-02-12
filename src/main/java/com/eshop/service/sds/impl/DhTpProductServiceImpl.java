package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DhTpProduct;
import com.eshop.mapper.sds.DhTpProductMapper;
import com.eshop.service.sds.IDhTpProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 敦煌商品 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class DhTpProductServiceImpl extends ServiceImpl<DhTpProductMapper, DhTpProduct> implements IDhTpProductService {

}

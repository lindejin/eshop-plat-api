package com.eshop.service.sds.impl;

import com.eshop.entity.sds.CommonProductSkuAttr;
import com.eshop.mapper.sds.CommonProductSkuAttrMapper;
import com.eshop.service.sds.ICommonProductSkuAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 通用库商品sku属性 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class CommonProductSkuAttrServiceImpl extends ServiceImpl<CommonProductSkuAttrMapper, CommonProductSkuAttr> implements ICommonProductSkuAttrService {

}

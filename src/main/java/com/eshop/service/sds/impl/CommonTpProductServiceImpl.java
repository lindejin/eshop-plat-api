package com.eshop.service.sds.impl;

import com.eshop.entity.sds.CommonTpProduct;
import com.eshop.mapper.sds.CommonTpProductMapper;
import com.eshop.service.sds.ICommonTpProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 通用库商品模板 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class CommonTpProductServiceImpl extends ServiceImpl<CommonTpProductMapper, CommonTpProduct> implements ICommonTpProductService {

}

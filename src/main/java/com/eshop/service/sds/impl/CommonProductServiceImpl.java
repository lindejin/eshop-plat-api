package com.eshop.service.sds.impl;

import com.eshop.entity.sds.CommonProduct;
import com.eshop.mapper.sds.CommonProductMapper;
import com.eshop.service.sds.ICommonProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 通用库商品 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class CommonProductServiceImpl extends ServiceImpl<CommonProductMapper, CommonProduct> implements ICommonProductService {

}

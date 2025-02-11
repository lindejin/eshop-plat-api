package com.eshop.service.collect.impl;

import com.eshop.entity.collect.ClProduct;
import com.eshop.mapper.collect.ClProductMapper;
import com.eshop.service.collect.IClProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采集商品 服务实现类
 * </p>
 *
 * @author collect
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_collect")
@Service
public class ClProductServiceImpl extends ServiceImpl<ClProductMapper, ClProduct> implements IClProductService {

}

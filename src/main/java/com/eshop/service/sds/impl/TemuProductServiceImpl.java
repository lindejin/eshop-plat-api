package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProduct;
import com.eshop.mapper.sds.TemuProductMapper;
import com.eshop.service.sds.ITemuProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * temu模版基础信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemuProductServiceImpl extends ServiceImpl<TemuProductMapper, TemuProduct> implements ITemuProductService {

}

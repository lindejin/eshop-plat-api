package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuTpProduct;
import com.eshop.mapper.sds.TemuTpProductMapper;
import com.eshop.service.sds.ITemuTpProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * temu模版基础信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemuTpProductServiceImpl extends ServiceImpl<TemuTpProductMapper, TemuTpProduct> implements ITemuTpProductService {

}

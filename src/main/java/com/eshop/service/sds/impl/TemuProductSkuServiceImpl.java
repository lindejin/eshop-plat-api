package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProductSku;
import com.eshop.mapper.sds.TemuProductSkuMapper;
import com.eshop.service.sds.ITemuProductSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品sku信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemuProductSkuServiceImpl extends ServiceImpl<TemuProductSkuMapper, TemuProductSku> implements ITemuProductSkuService {

}

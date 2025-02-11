package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProductSkuWarehous;
import com.eshop.mapper.sds.TemuProductSkuWarehousMapper;
import com.eshop.service.sds.ITemuProductSkuWarehousService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品 库存信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemuProductSkuWarehousServiceImpl extends ServiceImpl<TemuProductSkuWarehousMapper, TemuProductSkuWarehous> implements ITemuProductSkuWarehousService {

}

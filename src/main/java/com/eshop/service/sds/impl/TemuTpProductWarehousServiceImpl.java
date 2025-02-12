package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuTpProductWarehous;
import com.eshop.mapper.sds.TemuTpProductWarehousMapper;
import com.eshop.service.sds.ITemuTpProductWarehousService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品 库存信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemuTpProductWarehousServiceImpl extends ServiceImpl<TemuTpProductWarehousMapper, TemuTpProductWarehous> implements ITemuTpProductWarehousService {

}

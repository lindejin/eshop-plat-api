package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProductSkuSensitive;
import com.eshop.mapper.sds.TemuProductSkuSensitiveMapper;
import com.eshop.service.sds.ITemuProductSkuSensitiveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品 模版敏感属性 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemuProductSkuSensitiveServiceImpl extends ServiceImpl<TemuProductSkuSensitiveMapper, TemuProductSkuSensitive> implements ITemuProductSkuSensitiveService {

}

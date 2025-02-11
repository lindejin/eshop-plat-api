package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProductSkuAttr;
import com.eshop.mapper.sds.TemuProductSkuAttrMapper;
import com.eshop.service.sds.ITemuProductSkuAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品模版属性值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemuProductSkuAttrServiceImpl extends ServiceImpl<TemuProductSkuAttrMapper, TemuProductSkuAttr> implements ITemuProductSkuAttrService {

}

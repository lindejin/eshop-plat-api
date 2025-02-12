package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuTpProductAttrVal;
import com.eshop.mapper.sds.TemuTpProductAttrValMapper;
import com.eshop.service.sds.ITemuTpProductAttrValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品模版属性值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemuTpProductAttrValServiceImpl extends ServiceImpl<TemuTpProductAttrValMapper, TemuTpProductAttrVal> implements ITemuTpProductAttrValService {

}

package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuTpProductAttr;
import com.eshop.mapper.sds.TemuTpProductAttrMapper;
import com.eshop.service.sds.ITemuTpProductAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * temu产品模版属性列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemuTpProductAttrServiceImpl extends ServiceImpl<TemuTpProductAttrMapper, TemuTpProductAttr> implements ITemuTpProductAttrService {

}

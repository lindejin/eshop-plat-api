package com.eshop.service.sds.impl;

import com.eshop.entity.sds.SdsProductAttrVal;
import com.eshop.mapper.sds.SdsProductAttrValMapper;
import com.eshop.service.sds.ISdsProductAttrValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sds-产品属性值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class SdsProductAttrValServiceImpl extends ServiceImpl<SdsProductAttrValMapper, SdsProductAttrVal> implements ISdsProductAttrValService {

}

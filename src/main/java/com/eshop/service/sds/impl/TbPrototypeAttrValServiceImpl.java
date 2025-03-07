package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbPrototypeAttrVal;
import com.eshop.mapper.sds.TbPrototypeAttrValMapper;
import com.eshop.service.sds.ITbPrototypeAttrValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 样机属性值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TbPrototypeAttrValServiceImpl extends ServiceImpl<TbPrototypeAttrValMapper, TbPrototypeAttrVal> implements ITbPrototypeAttrValService {

}

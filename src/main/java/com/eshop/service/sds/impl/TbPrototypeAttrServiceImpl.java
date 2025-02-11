package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbPrototypeAttr;
import com.eshop.mapper.sds.TbPrototypeAttrMapper;
import com.eshop.service.sds.ITbPrototypeAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 样机属性 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TbPrototypeAttrServiceImpl extends ServiceImpl<TbPrototypeAttrMapper, TbPrototypeAttr> implements ITbPrototypeAttrService {

}

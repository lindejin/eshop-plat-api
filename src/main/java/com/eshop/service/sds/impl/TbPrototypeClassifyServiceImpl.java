package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbPrototypeClassify;
import com.eshop.mapper.sds.TbPrototypeClassifyMapper;
import com.eshop.service.sds.ITbPrototypeClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 样机所选素材分类 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbPrototypeClassifyServiceImpl extends ServiceImpl<TbPrototypeClassifyMapper, TbPrototypeClassify> implements ITbPrototypeClassifyService {

}

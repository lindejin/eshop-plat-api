package com.eshop.service.sds.impl;

import com.eshop.entity.sds.SdsCategory;
import com.eshop.mapper.sds.SdsCategoryMapper;
import com.eshop.service.sds.ISdsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sds类目属性值	 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class SdsCategoryServiceImpl extends ServiceImpl<SdsCategoryMapper, SdsCategory> implements ISdsCategoryService {

}

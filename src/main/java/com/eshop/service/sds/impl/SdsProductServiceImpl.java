package com.eshop.service.sds.impl;

import com.eshop.entity.sds.SdsProduct;
import com.eshop.mapper.sds.SdsProductMapper;
import com.eshop.service.sds.ISdsProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sds-产品(产品 + 图片= 成品) 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class SdsProductServiceImpl extends ServiceImpl<SdsProductMapper, SdsProduct> implements ISdsProductService {

}

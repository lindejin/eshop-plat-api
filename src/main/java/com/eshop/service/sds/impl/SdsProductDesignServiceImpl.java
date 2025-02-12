package com.eshop.service.sds.impl;

import com.eshop.entity.sds.SdsProductDesign;
import com.eshop.mapper.sds.SdsProductDesignMapper;
import com.eshop.service.sds.ISdsProductDesignService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sds-产品设计队列 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class SdsProductDesignServiceImpl extends ServiceImpl<SdsProductDesignMapper, SdsProductDesign> implements ISdsProductDesignService {

}

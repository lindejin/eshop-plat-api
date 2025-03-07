package com.eshop.service.sds.impl;

import com.eshop.entity.sds.SdsLayerimgs;
import com.eshop.mapper.sds.SdsLayerimgsMapper;
import com.eshop.service.sds.ISdsLayerimgsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sds-图片素材(产品 + 图片= 成品) 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class SdsLayerimgsServiceImpl extends ServiceImpl<SdsLayerimgsMapper, SdsLayerimgs> implements ISdsLayerimgsService {

}

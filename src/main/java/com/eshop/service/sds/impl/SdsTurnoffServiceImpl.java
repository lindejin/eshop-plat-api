package com.eshop.service.sds.impl;

import com.eshop.entity.sds.SdsTurnoff;
import com.eshop.mapper.sds.SdsTurnoffMapper;
import com.eshop.service.sds.ISdsTurnoffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sds成品 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class SdsTurnoffServiceImpl extends ServiceImpl<SdsTurnoffMapper, SdsTurnoff> implements ISdsTurnoffService {

}

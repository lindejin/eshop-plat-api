package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbPlatformTransport;
import com.eshop.mapper.logistics.TbPlatformTransportMapper;
import com.eshop.service.logistics.ITbPlatformTransportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 平台认可的物流方式 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_logistics")
@Service
public class TbPlatformTransportServiceImpl extends ServiceImpl<TbPlatformTransportMapper, TbPlatformTransport> implements ITbPlatformTransportService {

}

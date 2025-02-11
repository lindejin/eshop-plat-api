package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuTpVideo;
import com.eshop.mapper.sds.TemuTpVideoMapper;
import com.eshop.service.sds.ITemuTpVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu模版视频列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemuTpVideoServiceImpl extends ServiceImpl<TemuTpVideoMapper, TemuTpVideo> implements ITemuTpVideoService {

}

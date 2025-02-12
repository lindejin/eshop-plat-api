package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProductVideo;
import com.eshop.mapper.sds.TemuProductVideoMapper;
import com.eshop.service.sds.ITemuProductVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu模版视频列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemuProductVideoServiceImpl extends ServiceImpl<TemuProductVideoMapper, TemuProductVideo> implements ITemuProductVideoService {

}

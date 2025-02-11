package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TkGlobalProductPublish;
import com.eshop.mapper.sds.TkGlobalProductPublishMapper;
import com.eshop.service.sds.ITkGlobalProductPublishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * TK全球商品发布信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TkGlobalProductPublishServiceImpl extends ServiceImpl<TkGlobalProductPublishMapper, TkGlobalProductPublish> implements ITkGlobalProductPublishService {

}

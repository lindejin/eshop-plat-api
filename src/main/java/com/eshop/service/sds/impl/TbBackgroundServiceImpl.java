package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbBackground;
import com.eshop.mapper.sds.TbBackgroundMapper;
import com.eshop.service.sds.ITbBackgroundService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 背景 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TbBackgroundServiceImpl extends ServiceImpl<TbBackgroundMapper, TbBackground> implements ITbBackgroundService {

}

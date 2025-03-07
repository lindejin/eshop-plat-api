package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbPrototypeSdParam;
import com.eshop.mapper.sds.TbPrototypeSdParamMapper;
import com.eshop.service.sds.ITbPrototypeSdParamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 样机生成款式sd参数 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TbPrototypeSdParamServiceImpl extends ServiceImpl<TbPrototypeSdParamMapper, TbPrototypeSdParam> implements ITbPrototypeSdParamService {

}

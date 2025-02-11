package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbPrototypeClipRange;
import com.eshop.mapper.sds.TbPrototypeClipRangeMapper;
import com.eshop.service.sds.ITbPrototypeClipRangeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链定位加工递增百分比 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TbPrototypeClipRangeServiceImpl extends ServiceImpl<TbPrototypeClipRangeMapper, TbPrototypeClipRange> implements ITbPrototypeClipRangeService {

}

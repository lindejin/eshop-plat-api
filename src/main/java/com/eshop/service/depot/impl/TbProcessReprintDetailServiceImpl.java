package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbProcessReprintDetail;
import com.eshop.mapper.depot.TbProcessReprintDetailMapper;
import com.eshop.service.depot.ITbProcessReprintDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 成品补打明细 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbProcessReprintDetailServiceImpl extends ServiceImpl<TbProcessReprintDetailMapper, TbProcessReprintDetail> implements ITbProcessReprintDetailService {

}

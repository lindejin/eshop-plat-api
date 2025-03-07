package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbStorageDetail;
import com.eshop.mapper.depot.TbStorageDetailMapper;
import com.eshop.service.depot.ITbStorageDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 入库单明细 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbStorageDetailServiceImpl extends ServiceImpl<TbStorageDetailMapper, TbStorageDetail> implements ITbStorageDetailService {

}

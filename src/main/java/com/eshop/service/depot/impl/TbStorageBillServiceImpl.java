package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbStorageBill;
import com.eshop.mapper.depot.TbStorageBillMapper;
import com.eshop.service.depot.ITbStorageBillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 入库单 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbStorageBillServiceImpl extends ServiceImpl<TbStorageBillMapper, TbStorageBill> implements ITbStorageBillService {

}

package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbProcessSku;
import com.eshop.mapper.depot.TbProcessSkuMapper;
import com.eshop.service.depot.ITbProcessSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 加工sku信息 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbProcessSkuServiceImpl extends ServiceImpl<TbProcessSkuMapper, TbProcessSku> implements ITbProcessSkuService {

}

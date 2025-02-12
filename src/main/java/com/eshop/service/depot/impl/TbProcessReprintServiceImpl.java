package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbProcessReprint;
import com.eshop.mapper.depot.TbProcessReprintMapper;
import com.eshop.service.depot.ITbProcessReprintService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 成品补打列表 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class TbProcessReprintServiceImpl extends ServiceImpl<TbProcessReprintMapper, TbProcessReprint> implements ITbProcessReprintService {

}

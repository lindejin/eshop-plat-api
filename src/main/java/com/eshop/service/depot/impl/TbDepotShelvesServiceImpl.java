package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbDepotShelves;
import com.eshop.mapper.depot.TbDepotShelvesMapper;
import com.eshop.service.depot.ITbDepotShelvesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 仓库货架 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class TbDepotShelvesServiceImpl extends ServiceImpl<TbDepotShelvesMapper, TbDepotShelves> implements ITbDepotShelvesService {

}

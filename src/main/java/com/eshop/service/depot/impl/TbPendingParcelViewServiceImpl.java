package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbPendingParcelView;
import com.eshop.mapper.depot.TbPendingParcelViewMapper;
import com.eshop.service.depot.ITbPendingParcelViewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbPendingParcelViewServiceImpl extends ServiceImpl<TbPendingParcelViewMapper, TbPendingParcelView> implements ITbPendingParcelViewService {

}

package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbFlexibleCustomizeStyleDetail;
import com.eshop.mapper.depot.TbFlexibleCustomizeStyleDetailMapper;
import com.eshop.service.depot.ITbFlexibleCustomizeStyleDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 柔性定制item 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class TbFlexibleCustomizeStyleDetailServiceImpl extends ServiceImpl<TbFlexibleCustomizeStyleDetailMapper, TbFlexibleCustomizeStyleDetail> implements ITbFlexibleCustomizeStyleDetailService {

}

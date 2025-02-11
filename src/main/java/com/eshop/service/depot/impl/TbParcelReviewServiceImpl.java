package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbParcelReview;
import com.eshop.mapper.depot.TbParcelReviewMapper;
import com.eshop.service.depot.ITbParcelReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹复核 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbParcelReviewServiceImpl extends ServiceImpl<TbParcelReviewMapper, TbParcelReview> implements ITbParcelReviewService {

}

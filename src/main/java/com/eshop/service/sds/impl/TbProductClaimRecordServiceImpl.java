package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbProductClaimRecord;
import com.eshop.mapper.sds.TbProductClaimRecordMapper;
import com.eshop.service.sds.ITbProductClaimRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 认领记录 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbProductClaimRecordServiceImpl extends ServiceImpl<TbProductClaimRecordMapper, TbProductClaimRecord> implements ITbProductClaimRecordService {

}

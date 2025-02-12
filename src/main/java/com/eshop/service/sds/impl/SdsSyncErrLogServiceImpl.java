package com.eshop.service.sds.impl;

import com.eshop.entity.sds.SdsSyncErrLog;
import com.eshop.mapper.sds.SdsSyncErrLogMapper;
import com.eshop.service.sds.ISdsSyncErrLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * sds数据同步异常日志	 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class SdsSyncErrLogServiceImpl extends ServiceImpl<SdsSyncErrLogMapper, SdsSyncErrLog> implements ISdsSyncErrLogService {

}

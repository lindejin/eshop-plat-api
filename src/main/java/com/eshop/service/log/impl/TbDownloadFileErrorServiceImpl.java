package com.eshop.service.log.impl;

import com.eshop.entity.log.TbDownloadFileError;
import com.eshop.mapper.log.TbDownloadFileErrorMapper;
import com.eshop.service.log.ITbDownloadFileErrorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 文件下载失败记录 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_log")
@Service
public class TbDownloadFileErrorServiceImpl extends ServiceImpl<TbDownloadFileErrorMapper, TbDownloadFileError> implements ITbDownloadFileErrorService {

}

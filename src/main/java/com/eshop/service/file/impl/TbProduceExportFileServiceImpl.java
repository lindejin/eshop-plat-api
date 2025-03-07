package com.eshop.service.file.impl;

import com.eshop.entity.file.TbProduceExportFile;
import com.eshop.mapper.file.TbProduceExportFileMapper;
import com.eshop.service.file.ITbProduceExportFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 下载列表 服务实现类
 * </p>
 *
 * @author file
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_file")
@Service
public class TbProduceExportFileServiceImpl extends ServiceImpl<TbProduceExportFileMapper, TbProduceExportFile> implements ITbProduceExportFileService {

}

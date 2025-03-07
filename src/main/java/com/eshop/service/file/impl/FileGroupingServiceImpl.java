package com.eshop.service.file.impl;

import com.eshop.entity.file.FileGrouping;
import com.eshop.mapper.file.FileGroupingMapper;
import com.eshop.service.file.IFileGroupingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 文件分组/分类 服务实现类
 * </p>
 *
 * @author file
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_file")
@Service
public class FileGroupingServiceImpl extends ServiceImpl<FileGroupingMapper, FileGrouping> implements IFileGroupingService {

}

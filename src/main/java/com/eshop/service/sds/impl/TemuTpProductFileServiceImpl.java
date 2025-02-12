package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuTpProductFile;
import com.eshop.mapper.sds.TemuTpProductFileMapper;
import com.eshop.service.sds.ITemuTpProductFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品模版 文件相关信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemuTpProductFileServiceImpl extends ServiceImpl<TemuTpProductFileMapper, TemuTpProductFile> implements ITemuTpProductFileService {

}

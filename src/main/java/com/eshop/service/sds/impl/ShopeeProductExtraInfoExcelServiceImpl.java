package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeProductExtraInfoExcel;
import com.eshop.mapper.sds.ShopeeProductExtraInfoExcelMapper;
import com.eshop.service.sds.IShopeeProductExtraInfoExcelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮商品(spu)-最近30统计值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ShopeeProductExtraInfoExcelServiceImpl extends ServiceImpl<ShopeeProductExtraInfoExcelMapper, ShopeeProductExtraInfoExcel> implements IShopeeProductExtraInfoExcelService {

}

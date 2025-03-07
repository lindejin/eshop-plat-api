package com.eshop.util.shop;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.eshop.entity.config.TbShop;
import com.eshop.entity.order.TbOrder;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import com.eshop.util.shop.app.DhAppClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ldj
 * @date 2024/3/15 13:56
 * @Description: ...
 * @Version 1.0
 */
@Slf4j
@Component
public class PlatformAppClientUtils {

    @Resource
    private DhAppClientUtils dhAppClientUtils;

    @Resource
    private PlatformAppUtil platformAppUtil;

    @Resource
    private ITbShopService iTbShopService;

    /**
     * 获取dhgate app client dto
     */
    public DhAppClientDTO getDhAppClientDTO(TbShop shopDO) {
        String paramStaticJson = platformAppUtil.getAppParamJson(shopDO.getPlatformCode());
        return dhAppClientUtils.getDhAppClientDTO(shopDO.getId(), paramStaticJson);
    }

    /**
     * 获取dhgate app client dto
     */
    public DhAppClientDTO getDhAppClientDTO(Long shopId) {
        LambdaQueryWrapper<TbShop> qw = new LambdaQueryWrapper<>();
        qw.in(TbShop::getId, shopId);
        TbShop shopDO = iTbShopService.getOne(qw);
        String paramStaticJson = platformAppUtil.getAppParamJson(shopDO.getPlatformCode());
        return dhAppClientUtils.getDhAppClientDTO(shopId, paramStaticJson);
    }
    /**
     * 获取dhgate app client dto
     */
    public DhAppClientDTO getDhAppClientDTO(Long shopId, String platformCode) {
        String paramStaticJson = platformAppUtil.getAppParamJson(platformCode);
        return dhAppClientUtils.getDhAppClientDTO(shopId, paramStaticJson);
    }
}

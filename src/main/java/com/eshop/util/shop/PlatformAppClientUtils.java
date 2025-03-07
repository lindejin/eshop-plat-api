package com.eshop.util.shop;

import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import com.eshop.util.shop.app.DhAppClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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


    /**
     * 获取dhgate app client dto
     */
    public DhAppClientDTO getDhAppClientDTO(Long shopId, String platformCode) {
        String paramStaticJson = platformAppUtil.getAppParamJson(platformCode);
        return dhAppClientUtils.getDhAppClientDTO(shopId, paramStaticJson);
    }
}

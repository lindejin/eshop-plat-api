package com.eshop.util.shop;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.eshop.entity.config.TbPlatform;
import com.eshop.service.config.ITbPlatformService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class PlatformAppUtil {

    @Resource
    private ITbPlatformService platformService;

    /**
     * 获取应用静态变量
     */
    public String getAppParamJson(String platformCode) {
        TbPlatform platform = null;
        try {
            LambdaQueryWrapper<TbPlatform> qw = new LambdaQueryWrapper<>();
            qw.eq(TbPlatform::getPlatformCode, platformCode);
            platform = platformService.getOne(qw);
        } catch (Exception e) {
            throw new RuntimeException("查询应用参数异常:" + platformCode);
        }

        if (platform == null) {
            throw new RuntimeException("应用参数异常！appId:" + platformCode);
        }

        String appParamJson = platform.getParamStaticJson();
        if (StringUtils.isBlank(appParamJson)) {
            throw new RuntimeException("应用参数异常！appParamJson查询为空，platformCode:" + platformCode);
        }
        return appParamJson;

    }

}

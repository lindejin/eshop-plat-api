package com.eshop.api.modules.util.shop;

import com.eshop.db.config.service.PlatformAppService;
import com.eshop.modal.modal.eshop_config.TbPlatformApp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class PlatformAppUtil {

    @Resource
    private PlatformAppService platformAppService;

    /**
     * 获取应用静态变量
     */
    public String getAppParamJson(Long appId) {
        TbPlatformApp tbPlatformApp = null;
        try {
            tbPlatformApp = platformAppService.selectOneByProperty(TbPlatformApp::getId, appId);
        } catch (Exception e) {
            throw new RuntimeException("查询应用参数异常:" + appId);
        }

        if (tbPlatformApp == null) {
            throw new RuntimeException("应用参数异常！appId:" + appId);
        }

        String appParamJson = tbPlatformApp.getAppParamJson();
        if (StringUtils.isBlank(appParamJson)) {
            throw new RuntimeException("应用参数异常！appParamJson查询为空，appId:" + appId);
        }
        return appParamJson;

    }

}

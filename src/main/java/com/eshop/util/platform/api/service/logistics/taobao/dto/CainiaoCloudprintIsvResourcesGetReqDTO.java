package com.eshop.util.platform.api.service.logistics.taobao.dto;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 16:07
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintIsvResourcesGetReqDTO {

    /**
     * isv资源类型，分为：TEMPLATE（表示模板），PRINT_ITEM（打印项），CUSTOM_AREA（预设自定义区）
     */
    private String isv_resource_type;
}

package com.eshop.util.platform.api.service.logistics.taobao.vo;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-11 21:57
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoWaybillIiQueryByWaybillcodeResponse {

    /**
     * 打印数据
     */
    private CainiaoWaybillIiQueryByWaybillcodeWaybillCloudPrintWithResultDescResponse modules;
    //返回请求id
    private String request_id;
}

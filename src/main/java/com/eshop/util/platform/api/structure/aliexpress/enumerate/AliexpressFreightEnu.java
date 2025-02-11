package com.eshop.util.platform.api.structure.aliexpress.enumerate;

/**
 * @author ldj
 * @date 2024/2/28 14:26
 * @Description: ...
 * @Version 1.0
 */
public enum AliexpressFreightEnu {

    //request.setApiName("aliexpress.freight.redefining.listfreighttemplate");
    //用户运费模板列表信息
    LIST_FREIGHT_TEMPLATE("aliexpress.freight.redefining.listfreighttemplate"),
    //request.setApiName("aliexpress.freight.redefining.calculatefreight");
    //计算运费
    CALCULATE_FREIGHT("aliexpress.freight.redefining.calculatefreight"),
    //request.setApiName("aliexpress.freight.redefining.getfreightsettingbytemplatequery");
    //获取运费模板设置信息
    GET_FREIGHT_SETTING_BY_TEMPLATE_QUERY("aliexpress.freight.redefining.getfreightsettingbytemplatequery");

    private final String apiName;

    AliexpressFreightEnu(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return this.apiName;
    }
}

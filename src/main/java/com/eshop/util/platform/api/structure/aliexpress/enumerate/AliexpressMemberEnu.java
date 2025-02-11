package com.eshop.util.platform.api.structure.aliexpress.enumerate;

/**
 * @author ldj
 * @date 2024/2/29 15:17
 * @Description: ...
 * @Version 1.0
 */
public enum AliexpressMemberEnu {
    //request.setApiName("aliexpress.member.redefining.uicquerytbnick");
    //查询淘宝的nickName
    UIC_QUERY_TB_NICK("aliexpress.member.redefining.uicquerytbnick"),
    //request.setApiName("aliexpress.member.ds.orderdata.save");
    //收集下单的用户和订单金额等信息
    DS_ORDER_DATA_SAVE("aliexpress.member.ds.orderdata.save"),
    //request.setApiName("aliexpress.member.oauth.authorize");
    //oauth授权
    OAUTH_AUTHORIZE("aliexpress.member.oauth.authorize"),
    //request.setApiName("aliexpress.member.redefining.queryaccountlevel");
    //查询会员账户等级
    QUERY_ACCOUNT_LEVEL("aliexpress.member.redefining.queryaccountlevel");


    private final String apiName;

    AliexpressMemberEnu(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return this.apiName;
    }
}

package com.eshop.util.platform.api.service.account.dewu.vo;

@lombok.Getter
@lombok.Setter
public class DewuMerchantBaseInfoVO {

    //merchant_id	number	-	商户id
    private Long merchant_id;
    //type_id	number	-	商户类型0.个人vip商户1.急速发货商户2.企业商户3.认证商户4.跨境商家5.个人普通商户6-海外个人7-品牌方8-海外企业
    private Integer type_id;
}

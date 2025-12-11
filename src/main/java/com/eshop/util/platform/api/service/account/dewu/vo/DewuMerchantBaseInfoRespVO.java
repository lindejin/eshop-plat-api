package com.eshop.util.platform.api.service.account.dewu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class DewuMerchantBaseInfoRespVO extends BaseResponseVO {

    //参数名称	参数类型	参数示例	参数描述
    //domain	string	-	-
    private String domain;
    //code	number	-	-
    private Integer code;
    //msg	string	-	-
    private String msg;
    private String trace_id;
    private String status;
    //data	object	-	MerchantResponse
    private DewuMerchantBaseInfoVO data;
    //errors	array	-	Error
    private List<DewuMerchantBaseInfoErrorVO> errors;

    /**
     * 提取到外面方便处理
     */
    //merchant_id	number	-	商户id
    private Long merchant_id;
    //type_id	number	-	商户类型0.个人vip商户1.急速发货商户2.企业商户3.认证商户4.跨境商家5.个人普通商户6-海外个人7-品牌方8-海外企业
    private Integer type_id;
}

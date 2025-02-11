package com.eshop.util.platform.api.service.product.aliexpress.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rch
 * @date 2024/4/2 11:22
 * @Description: 半托管商品新发第二段提交
 * @Version 1.0
 */
@Getter
@Setter
public class AePopChoiceProductQueryRespVO {

    //@ApiModelProperty(value = "相应信息")
    private String respBody;
    //error_message	String	异常信息
    //@ApiModelProperty(value = "异常信息")
    private String errorMessage;
    //error_code	String	异常编码
    //@ApiModelProperty(value = "异常编码")
    private String errorCode;
    //@ApiModelProperty(value = "半托管商品详情")
    private AePopChoiceProductQueryVO aePopChoiceProductQueryVO;
    //success	Boolean	服务调用是否成功
    private Boolean success;
}

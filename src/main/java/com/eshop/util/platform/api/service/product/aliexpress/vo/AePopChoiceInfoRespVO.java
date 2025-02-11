package com.eshop.util.platform.api.service.product.aliexpress.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author rch
 * @date 2024/4/3 16:39
 * @Description: ...
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AePopChoiceInfoRespVO {
    private String respBody;
    //error_message	String	异常信息
    private String errorMessage;
    //error_code	String	异常编码
    private String errorCode;
    //attributes	Object[]	list
    private List<PopChoiceCountryVO> popChoiceCountryList;
    private List<AePopChoiceWarehouseRespVO> popChoiceWarehouseList;
    //success	Boolean	服务调用是否成功
    private Boolean success;
}

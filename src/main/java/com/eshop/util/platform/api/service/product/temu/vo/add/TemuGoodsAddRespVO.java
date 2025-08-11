package com.eshop.util.platform.api.service.product.temu.vo.add;

import com.eshop.util.platform.api.structure.BaseResponseVO;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddRespVO extends BaseResponseVO {

    //参数接口	参数类型	说明
    //result	OBJECT	result
    //success	BOOLEAN	status
    //errorCode	INTEGER	error code
    //errorMsg	STRING	error message

    private TemuGoodsAddResultVO result;
    private Boolean success;
    private Integer errorCode;
    private String errorMsg;

}
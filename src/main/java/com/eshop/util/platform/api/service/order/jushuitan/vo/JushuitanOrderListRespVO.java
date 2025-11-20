package com.eshop.util.platform.api.service.order.jushuitan.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanOrderListRespVO extends BaseResponseVO {

    //code	integer	0	错误码
    private Integer code;
    //msg	string	执行成功	错误描述
    private String msg;
    //data	object	
    private JushuitanOrderListDataRespVO data;	

}

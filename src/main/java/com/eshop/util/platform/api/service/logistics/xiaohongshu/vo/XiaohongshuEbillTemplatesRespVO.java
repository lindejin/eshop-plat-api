package com.eshop.util.platform.api.service.logistics.xiaohongshu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
public class XiaohongshuEbillTemplatesRespVO extends BaseResponseVO {
    //参数名称	参数类型	参数描述
    //error_code	number	返回值code
    private Integer error_code;
    //success	boolean	请求是否成功
    private Boolean success;
    //error_msg	string	错误信息
    private String error_msg;
    //data	object	-
    private XiaohongshuEbillTemplateDataVO data;

}

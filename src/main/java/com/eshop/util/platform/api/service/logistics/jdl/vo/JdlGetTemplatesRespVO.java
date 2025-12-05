package com.eshop.util.platform.api.service.logistics.jdl.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
public class JdlGetTemplatesRespVO extends BaseResponseVO {

    //code	Integer	1000	状态码，1000代表成功。参照下文错误码解释。长度1-10
    private Integer code;
    //message	String	请求成功	状态码信息说明，参照下文错误码解释。长度255
    private String message;
    //data	TemplatesDto		模板数据资源，当状态码不为1000时此项不返回。
    private JdlTemplatesDataVO data;
}

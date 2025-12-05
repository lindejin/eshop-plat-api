package com.eshop.util.platform.api.service.logistics.jdl.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;


@lombok.Getter
@lombok.Setter
public class JdlPullDataRespVO extends BaseResponseVO {

    //prePrintDatas	List<PrePrintDataInfo>		密文面单信息列表，（密文数据传给打印插件后渲染出明文面单）。code不为1时不返回此参数。
    private java.util.List<JdlPrePrintDataInfoVO> prePrintDatas;
    //code	String	1	响应码，1代表成功获取打印数据。详细参照「错误码解释」。长度1-10
    private String code;
    //message	String	操作成功！	响应信息，对code的解释。详细参照「错误码解释」。长度255
    private String message;
    //objectId	String	d553f7a1-a0f2-4b00-92b4-1975f3b5a45e	请求参数objectId的值。长度10-50
    private String objectId;
}

package com.eshop.util.platform.api.service.logistics.douyin.vo;


@lombok.Getter
@lombok.Setter
public class DouyinWaybillApplyDataErrInfoVO {

    //字段名	类型	示例值	描述
    //track_no	String	1	运单号
    private String track_no;
    //order_id	String	1	订单号
    private String order_id;
    //err_code	Int32	1	错误码
    private Integer err_code;
    //err_msg	String	1	错误信息
    private String err_msg;
}

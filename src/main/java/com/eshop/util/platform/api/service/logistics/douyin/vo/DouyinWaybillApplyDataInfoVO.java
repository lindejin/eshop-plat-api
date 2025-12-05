package com.eshop.util.platform.api.service.logistics.douyin.vo;

@lombok.Getter
@lombok.Setter
public class DouyinWaybillApplyDataInfoVO {

    //字段名	类型	示例值	描述
    //order_id	String	1	订单号
    private String order_id;
    //track_no	String	1	运单号
    private String track_no;
    //print_data	String	1	加密的面单数据
    private String print_data;
    //sign	String	1	签名信息
    private String sign;
}

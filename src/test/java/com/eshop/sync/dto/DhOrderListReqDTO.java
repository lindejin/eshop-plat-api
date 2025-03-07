package com.eshop.sync.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/16 11:09
 * @Description: ...
 * @Version 1.0
 */
@Setter
@Getter
public class DhOrderListReqDTO {
    //请求参数
    //参数名称	参数类型	是否必须	取值说明	参数说明
    //endDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	结束时间
    private String endDate;
    //orderNo	String	否	卖家后台能查看；示例值：1455953150	订单号
    private String orderNo;
    //orderStatus	String	否	111000,订单取消;101003,等待买家付款;102001,买家已付款，等待平台确认;103001,等待发货;105001,买家申请退款，等待协商结果;105002,退款协议已达成;105003,部分退款后，等待发货;105004,买家取消退款申请;103002,已部分发货;101009,等待买家确认收货;106001,退款/退货协商中，等待协议达成;106002,买家投诉到平台;106003,协议已达成，执行中;102006,人工确认收货;102007,超过预定期限，自动确认收货;102111,交易成功;111111,交易关闭；示例值：101009,101003,多种状态时用英文逗号分隔，默认为空，查询所有订单	订单状态列表
    private String orderStatus;
    //buyerNickName	String	否	示例值：zhangsan	买家昵称
    private String buyerNickName;
    //querytimeType	String	必须	按哪种时间类型查询订单列表，值：1、下单时间 ,2、付款时间,3、更新时间 仅支持此三种时间类型查询	查询时间类型
    private String querytimeType;
    //startDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	开始时间
    private String startDate;
    //itemCode	String	否	产品号在页面详情的URL中即可查看到；示例值：180366586	产品编号
    private String itemCode;
    //pageSize	int	必须	示例值：10,表示每页10条记录	每页记录数
    private Integer pageSize;
    //pageNo	int	必须	示例值：10,表示第10页（返回值中pages为总页数，若超过总页数，则返回最后一页数据。）	第几页
    private Integer pageNo;
    //deliveryNo	String	否	示例值：1Z68A9X70467731838	运单号
    private String deliveryNo;
}

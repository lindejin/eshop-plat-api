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
public class DhOrderDisputeCloseListReqDTO {
    //请求参数
    //参数名称	参数类型	是否必须	取值说明	参数说明
    //pageNo	int	必须	示例值：10,表示第10页（返回值中pages为总页数，若超过总页数，则返回最后一页数据。）	第几页
    private Integer pageNo;
    //orderNo	String	否	卖家后台能查看；示例值：1455953150	订单号
    private String orderNo;
    //pageSize	int	必须	示例值：10,表示每页10条记录	每页记录数
    private Integer pageSize;
    //startDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	纠纷关闭开始时间
    private String startDate;
    //endDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	纠纷关闭结束时间
    private String endDate;
    //buyerNickName	String	否	示例值：zhangsan	买家昵称
    private String buyerNickName;
}

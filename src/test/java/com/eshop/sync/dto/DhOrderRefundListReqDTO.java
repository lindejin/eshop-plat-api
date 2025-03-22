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
public class DhOrderRefundListReqDTO {
    //请求参数
    //参数名称	参数类型	是否必须	取值说明	参数说明
    //refundStatus	String	必须		退款状态
    private String refundStatus;
    //applyStartDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	申请开始时间
    private String applyStartDate;
    //completeStartDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	完成开始时间
    private String completeStartDate;
    //completeEndDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	完成结束时间
    private String completeEndDate;
    //applyEndDate	String	必须	日期格式：yyyy-MM-dd HH:mm:ss,精确到秒；示例值：2014-01-12 18:20:21	申请结束时间
    private String applyEndDate;
    //pageSize	int	必须	示例值：10,表示每页10条记录	每页记录数
    private Integer pageSize;
    //orderNo	String	必须	3600012301	订单号
    private String orderNo;
    //pageNo	int	必须	示例值：10,表示第10页（返回值中pages为总页数，若超过总页数，则返回最后一页数据。）	第几页
    private Integer pageNo;
}

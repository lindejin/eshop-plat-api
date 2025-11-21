package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanTaoOrderListVO {

    //     "flag": "failure",
    private String flag;
    //     "code": 25,
    private Integer code;
    //     "message": "Invalid signature",
    private String message;
    //     "request_id": "15quv57w9uchd"
    private String request_id;

    //名称	类型	是否必须	示例值	描述
    //page_size	int		1	页大小
    private Integer page_size;
    //page_index	int		25	页索引
    private Integer page_index;
    //data_count	int		100	数据重量
    private Integer data_count;
    //page_count	int		4	页数
    private Integer page_count;
    //has_next	bool		true	是否有下一页
    private Boolean has_next;
    //orders	list			订单列表
    private List<JushuitanTaoOrderVO> orders;
}

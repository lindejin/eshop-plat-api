package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanTaoSaleOrderListVO {

    //名称	类型	是否必须	示例值	描述
    //page_size	int			页大小
    private Integer page_size;
    //page_index	int			页索引
    private Integer page_index;
    //data_count	int			数据总数
    private Integer data_count;
    //page_count	int			总页数
    private Integer page_count;
    //has_next	bool			是否有下一页
    private Boolean has_next;
    //datas	list			数据列表
    private List<JushuitanTaoSaleOrderVO> datas;
}

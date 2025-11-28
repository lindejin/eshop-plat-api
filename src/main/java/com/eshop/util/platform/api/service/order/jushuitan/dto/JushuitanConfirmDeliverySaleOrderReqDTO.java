package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanConfirmDeliverySaleOrderReqDTO {

    //io_id	integer	是	3542344	出仓单号，ERP内部单号，系统【销售出库单】页面中出仓单号
    private Long io_id;
    //lc_name	string	是	国通快递	快递公司，最大30
    private String lc_name;
    //l_id	string	是	20211202-2	快递单号，最大50；如果选择了跨境物流表示国际运单号
    private String l_id;
    //lc_id	string	是	OTHER.DOOR	快递公司代码
    private String lc_id;
    //wms_co_id	integer	否		发货仓编码
    private Long wms_co_id;
    //is_un_lid	boolean	否		是否跨境物流；选true渠道信息必填
    private Boolean is_un_lid;
    //tracking_code	string	否		渠道编码
    private String tracking_code;
    //tracking_info	string	否		发货渠道
    private String tracking_info;
    //tracking_type	number	否		货代id（货代设置中的ID）；默认值可以传1000
    private Integer tracking_type;
    //items	array	否		需要唯一码出库的商品节点
    private java.util.List<JushuitanConfirmDeliverySaleOrderItemReqDTO> items;
}

package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoOrderListReqDTO {

    //名称	类型	是否必须	示例值	描述
    //page_index	int	是	1	页码
    private Integer page_index;
    //page_size	int	是	25	页数，最大100
    private Integer page_size;
    //start_time	string		2019-01-02 00:00:00	开始时间
    private String start_time;
    //end_time	string		2019-01-02 00:00:00	结束时间
    private String end_time;
    //date_type	int		0	0:修改时间modified，2:订单日期order_date，3:发货时间send_date；非必填，默认0
    private Integer date_type;
    //wms_co_id	int		11322398	发货仓编号
    private Integer wms_co_id;
    //shop_id	int		12159435	店铺编号
    private Integer shop_id;
    //status	string		Sent	ERP订单状态：待付款：WaitPay；发货中：Delivering；被合并：Merged；异常：Question；被拆分：Split；等供销商|外仓发货：WaitOuterSent；已付款待审核：WaitConfirm；已客审待财审：WaitFConfirm；已发货：Sent；取消：Cancelled
    private String status;
    //not_status	string		Sent	不等于此状态
    private String not_status;
    //is_paid	bool		true	付款状态
    private Boolean is_paid;
    //has_invoice	bool		true	是否获取专票信息
    private Boolean has_invoice;
    //so_ids	string		"123,232"	线上单号列表，多个线上单号以逗号分开
    private String so_ids;
    //o_ids	int			内部订单号列表
    private String o_ids;
    //is_valid_pay	bool		true	查出无效支付信息
    private Boolean is_valid_pay;
    //start_ts	int		long类型	开始时间戳，sql server中的行版本号，该字段查询防止分页过程中漏单
    private Long start_ts;
    //is_get_total	bool			是否查询总条数，默认true
    private Boolean is_get_total;
    //archive	bool		true	是否查归档订单
    private Boolean archive;
    //order_types	string			订单类型（普通订单,补发订单,换货订单,天猫分销,天猫供销,协同订单,亚马逊货件单,唯品会JITX订单,唯品会JITX待寻仓订单,送仓订单, 普通订单-分销Plus,补发订单-分销Plus,换货订单-分销Plus,天猫供销-分销Plus,协同订单-分销Plus,亚马逊货件单-分销Plus,唯品会JITX订单-分销Plus,唯品会JITX待寻仓订单-分销Plus,送仓订单-分销Plus, 普通订单-供销Plus,补发订单-供销Plus,换货订单-供销Plus,天猫供销-供销Plus,协同订单-供销Plus,亚马逊货件单-供销Plus,唯品会JITX订单-供销Plus,唯品会JITX待寻仓订单-供销Plus,送仓订单-供销Plus, 普通订单-分销Plus-供销Plus,补发订单-分销Plus-供销Plus,换货订单-分销Plus-供销Plus,天猫供销-分销Plus-供销Plus,协同订单-分销Plus-供销Plus,亚马逊货件单-分销Plus-供销Plus,唯品会JITX订单-分销Plus-供销Plus,唯品会JITX待寻仓订单-分销Plus-供销Plus,送仓订单-分销Plus-供销Plus）
    private String order_types;
    //order_item_flds	string		"src_combine_sku_id,presale_date"	订单明细自定义查询字段：原组合商品编码,计划发货时间
    private String order_item_flds;
}

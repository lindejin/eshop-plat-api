package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanTaoSaleOrderVO {
    //名称	类型	是否必须	示例值	描述
    //co_id	int			公司编号
    private Long co_id;
    //shop_id	int			店铺编号
    private Long shop_id;
    //io_id	int			出库单号
    private Long io_id;
    //o_id	int			内部订单号
    private Long o_id;
    //so_id	string			线上订单号
    private String so_id;
    //created	string			登记时间
    private String created;
    //modified	string			修改时间
    private String modified;
    //status	string			出库单状态：Archive:归档,WaitConfirm:待出库,Confirmed:已出库,Cancelled:取消,Delete:作废,OuterConfirming:外部发货中
    private String status;
    //invoice_title	string			发票抬头
    private String invoice_title;
    //shop_buyer_id	string			买家帐号
    private String shop_buyer_id;
    //receiver_country	string			国家
    private String receiver_country;
    //receiver_state	string			省
    private String receiver_state;
    //receiver_city	string			市
    private String receiver_city;
    //receiver_district	string			区
    private String receiver_district;
    //buyer_message	string			买家留言
    private String buyer_message;
    //remark	string			卖家留言
    private String remark;
    //is_cod	bool			是否货到付款
    private Boolean is_cod;
    //pay_amount	string			应付金额
    private String pay_amount;
    //l_id	string			快递单号
    private String l_id;
    //io_date	string			出库日期
    private String io_date;
    //lc_id	string			快递公司编码
    private String lc_id;
    //stock_enabled	string			是否启用库存管理,on=使用库存；off=不使用
    private String stock_enabled;
    //labels	string			多标签
    private String labels;
    //paid_amount	string			已付金额
    private String paid_amount;
    //free_amount	string			优惠金额
    private String free_amount;
    //freight	string			运费
    private String freight;
    //weight	string			预估重量
    private String weight;
    //warehouse	string			仓库名称
    private String warehouse;
    //drp_co_id_from	string			分销商编号
    private String drp_co_id_from;
    //f_weight	string			实际重量
    private String f_weight;
    //order_type	string			单据类型
    private String order_type;
    // batchs	list			批次信息
    private List<JushuitanTaoSaleOrderBatchVO> batchs;
    //open_id	string			买家唯一id
    private String open_id;
    //is_print_express	string			快递单已打印
    private String is_print_express;
    //is_print	string			订单已打印
    private String is_print;
    //drp_info	string			供分销信息
    private String drp_info;
    //buyer_tax_no	string			发票税号
    private String buyer_tax_no;
    //logistics_company	string			快递公司名称
    private String logistics_company;
    //sns	list			SN唯一码信息
    private List<JushuitanTaoSaleOrderSnsVO> sns;
    //merge_so_id	string			被合并的线上单号
    private String merge_so_id;
    //wms_co_id	int			分仓编号
    private Long wms_co_id;
    //items	list			明细列表
    private List<JushuitanTaoSaleOrderItemVO> items;
    //shop_name	string			店铺名称
    private String shop_name;
    //business_staff	string			业务人员
    private String business_staff;
    //currency	string			货币类型
    private String currency;
    //node	string			线下备注
    private String node;
    //pay_date	string			付款日期
    private String pay_date;
    //seller_flag	int			旗帜
    private Integer seller_flag;
    //wave_id	string			拣货批次号
    private String wave_id;
    //order_staff_id	int			订单业务员编号
    private Long order_staff_id;
    //order_staff_name	string			订单业务员名称
    private String order_staff_name;
    //cb_finances	object			跨境财务信息
    private JushuitanTaoSaleOrderCbFinanceVO cb_finances;
    //ClusterInfos	list			子母单信息
    private  List<JushuitanTaoSaleOrderClusterInfoVO> ClusterInfos;
    //cb_financenew	object			新版跨境财务信息
    private JushuitanTaoSaleOrderCbFinanceNewVO cb_financenew;
    //gov_supplier_name	string			实际销售公司
    private String gov_supplier_name;
    //buyer_paid_amount	string			营收小计：买家实付
    private String buyer_paid_amount;
    //seller_income_amount	string			营收小计：卖家实收
    private String seller_income_amount;
}

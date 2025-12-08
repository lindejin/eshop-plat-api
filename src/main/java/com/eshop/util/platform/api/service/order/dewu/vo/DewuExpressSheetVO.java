package com.eshop.util.platform.api.service.order.dewu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class DewuExpressSheetVO {


    //参数名称	参数类型	参数示例	参数描述
    //mask_order_no	String	-	订单号
    //consignment_name	String	-	托寄物名称
    //printing_time	String	-	打印时间，格式yyyy-MM-dd HH:mm:ss
    //waybill_no	String	-	运单号
    //sub_waybill_no_list	Array	-	子运单号数组
    //logistics_code	String	-	承运商编码 (SF:顺丰,AD:安得物流,JD:京东快递,AX:安迅物流,DB:德邦,SN:苏宁物流,RRS:日日顺,HX:海信物流,EMS:中国邮政,LS:林氏物流,ZJS:宅急送,SBD:速必达物流,ANWL:安能物流,YMDD:壹米滴答,JGSY:京广速运,SXJD:顺心捷达,ZTKY:中通快运,ZT:中通快递,XMWL:小米物流,YD:韵达快递,ST:申通快递,JT:极兔快递,YT:圆通快递) 目前支持顺丰、京东、德邦，中通，日日顺,韵达,申通,极兔,圆通
    //logistics_product_code	String	-	承运商产品编码，SFBK：顺丰标快；SFTH：顺丰标快(陆运)；SFHKBK：标准快递；SFGJBK_IUOP：国际标快(+)-包裹；SFTHZP：特惠专配；SFZHBG：重货包裹B；SFBZLD：标准零担；SFSYKP：顺丰空配；SFLYBG：顺丰陆运包裹；SFTK：顺丰特快；SFBKL：顺丰标快（陆）；SFDSBK：电商标快；SFKH：顺丰卡航；SFKHB：顺丰卡航B；SFGJTHBS：国际特惠（保税）；SFGJDSBK：顺丰国际电商标快；JDLY：京东特惠送；JDKY：京东特快送；JDTKZH：特快重货；EMSBZ：EMS标准快递；EMSBG：EMS快递包裹；EMSDS：EMS代收到付；EMSTHKY：E特惠空运；EMSTHLY：E特惠陆运；EMSBS：电商标快；DBWX：德邦微小件；DB360：德邦大件快递360；DBJZ：德邦精准卡航；DBTKZD：德邦空运特快专递；DBZBRH：德邦重包入户；
    //transport_code	String	-	运输方式，LY：陆运；KY：空运
    //dest_address	Object	-	目的地地址
    //  province	String	-	目的地：省
    //  city	String	-	目的地：市
    //  region	String	-	目的地：区
    //  country	String	-	国家
    //  post_code	String	-	邮编
    //  detailed_address	String	-	详细地址（目前中通快递才会有值）
    //dest_name	String	-	收件人姓名
    //dest_mobile	String	-	收件人手机
    //dest_tel	String	-	收件人电话
    //make_waybill_time	String	-	下物流单日期，格式yyyy-MM-dd HH:mm:ss
    //site_info	Object	-	站点信息
    //  source_sort_center_name	String	-	始发分拣中心名称
    //  original_cross_code	String	-	始发滑道号
    //  original_table_trolley_code	String	-	始发笼车号
    //  target_sort_center_name	String	-	目的分拣中心名称
    //  destination_cross_code	String	-	目的滑道号
    //  destination_table_trolley_code	String	-	目的笼车号
    //  site_name	String	-	站点名称
    //  road	String	-	路区
    //  limit_type_code	String	-	特快送标签
    //  pro_code	String	-	产品代码
    //  dest_deptCode	String	-	路由信息（到方网点代码）
    //  coding_mapping	String	-	进港映射码
    //  dest_route_label	String	-	路由信息
    //  two_dimension_code	String	-	顺丰二维码
    //dest_code	String	-	目的地编码
    //zone_code	String	-	区域号码,
    //gathering_place	String	-	集包地,用于打印label
    //air_embargo	Integer	-	是否航空禁运品，1：是；0：否
    //sub_waybill_flag	Boolean	-	子运单真假标记
    //insure_value	Long	-	保价金额
    //pay_method	String	-	付款方式
    //article_number	String	-	货号
    //specification	String	-	规格
    //logistics_product_name	String	-	承运商产品名称
    //sheet_type	Integer	-	面单类型 1: 标准 2:母单 3:子单
    //total_number	Integer	-	面单总数量,子母单情况下，有值
    //sequence_number	Integer	-	面单当前序号,子母单情况下，有值
    //mother_waybill_no	String	-	母运单号,子母单情况下，有值
    //new_electron_sheet_data	String	-	新电子面单数据 JSON字符串
    //package_warnings	Array	-	包裹警示标志列表
    //version	Integer	-	(若使用得物打印组件打印面单，该字段无需关注) 打印面单样式版本，1:老样式,2:新样式，贴纸自带品牌直发字样,绘制面单时需要头部的得物logo和poizon
    //privacy_num	Object	-	隐私号数据（请注意，此字段必须接入，隐私号数据直接影响快递员电联与投递）
    //  num	String	-	隐私号-手机号
    //  ext_num	String	-	隐私号-转接号
    //merge_delivery_flag	Boolean	-	品牌直发合并发标识 true 代表是 false 或者 null 代表不是
    //merge_delivery_num	Integer	-	品牌直发合并发的订单数目

    private String mask_order_no;

    private String consignment_name;

    private String printing_time;

    private String waybill_no;

    private List<String> sub_waybill_no_list;

    private String logistics_code;

    private String logistics_product_code;

    private String transport_code;

    private String logistics_transport;

    private DewuWaybillAddressResponse dest_address;

    private String dest_name;

    private String dest_mobile;

    private String dest_tel;

    private String make_waybill_time;

    private DewuWaybillSiteInfoResponse site_info;

    private String dest_code;

    private String zone_code;

    private String gathering_place;

    private Integer air_embargo;

    private Boolean sub_waybill_flag;

    private Long insure_value;

    private String pay_method;

    private String article_number;

    private String specification;

    private String logistics_product_name;

    private Integer sheet_type;

    private Integer total_number;

    private Integer sequence_number;

    private String mother_waybill_no;

    private String pdf_token;

    private String pdf_url;

    private Boolean merge_delivery_flag;

    private Integer merge_delivery_num;

    private Integer version;

    private List<String> package_warnings;

    private DewuWaybillPrivacyNum privacy_num;

    private String new_electron_sheet_data;
}

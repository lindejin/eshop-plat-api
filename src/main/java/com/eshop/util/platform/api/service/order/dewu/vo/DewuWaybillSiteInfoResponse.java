package com.eshop.util.platform.api.service.order.dewu.vo;

@lombok.Getter
@lombok.Setter
public class DewuWaybillSiteInfoResponse {
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

    private String source_sort_center_name;

    private String original_cross_code;

    private String original_table_trolley_code;

    private String target_sort_center_name;

    private String destination_cross_code;

    private String destination_table_trolley_code;

    private String site_name;

    private String road;

    private String limit_type_code;

    private String pro_code;

    private String dest_deptCode;

    private String coding_mapping;

    private String two_dimension_code;

    private String dest_route_label;
}

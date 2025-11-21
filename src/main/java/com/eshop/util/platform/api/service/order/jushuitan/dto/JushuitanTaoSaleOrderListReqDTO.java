package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanTaoSaleOrderListReqDTO {

    //名称	类型	是否必须	示例值	描述
    //page_index	int	是		页索引
    private Integer page_index;
    //page_size	int	是		页长度，最大100
    private Integer page_size;
    //start_time	string			开始时间
    private String start_time;
    //end_time	string			结束时间
    private String end_time;
    //status	string			出库单状态：Archive:归档,WaitConfirm:待出库,Confirmed:已出库,Cancelled:取消,Delete:作废,OuterConfirming:外部发货中
    private String status;
    //wms_co_id	int			分仓编号
    private Long wms_co_id;
    //shop_id	int			店铺编号
    private Long shop_id;
    //so_ids	string		"111,222,333"	线上单号列表，多个线上单号以逗号分开
    private String so_ids;
    //o_ids	int			内部单号列表
    private List<Integer> o_ids;
    //io_ids	int			销售出库单号列表
    private List<Integer> io_ids;
    //date_type	int			时间类型 0:修改时间modified，2:出库时间io_date;默认0
    private Integer date_type;
    //is_get_supplier	bool			是否获取天猫分销信息
    private Boolean is_get_supplier;
    //is_get_total	bool			是否查询总条数
    private Boolean is_get_total;
    //start_ts	int			开始时间戳，sql server中的行版本号，该字段查询防止分页过程中漏单
    private Long start_ts;
    //wave_ids	list			拣货批次号
    private List<String> wave_ids;
    //archive	bool		true	是否查归档订单
    private Boolean archive;
    //is_get_cbfinance	bool			是否获取跨境财务信息
    private Boolean is_get_cbfinance;
    //owner_co_id	int			货主id
    private Integer owner_co_id;
}

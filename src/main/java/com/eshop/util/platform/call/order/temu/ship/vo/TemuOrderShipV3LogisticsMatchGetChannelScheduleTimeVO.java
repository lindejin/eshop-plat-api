package com.eshop.util.platform.call.order.temu.ship.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipV3LogisticsMatchGetChannelScheduleTimeVO {
    //bjDate	STRING	可预约日期 北京时间 格式yyyy-MM-dd
    private String bjDate;
    //bjStartTime	STRING	可预约日期的时间起点 北京时间 格式HH:mm
    private String bjStartTime;
    //bjEndTime	STRING	可预约日期的时间终点 北京时间 格式HH:mm
    private String bjEndTime;
}

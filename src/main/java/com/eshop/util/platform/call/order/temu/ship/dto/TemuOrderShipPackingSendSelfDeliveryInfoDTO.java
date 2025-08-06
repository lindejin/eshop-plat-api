package com.eshop.util.platform.call.order.temu.ship.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackingSendSelfDeliveryInfoDTO {

    //expressPackageNum	INTEGER	否	发货总箱数
    private Integer expressPackageNum;
    //deliveryContactNumber	STRING	否	电话号码
    private String deliveryContactNumber;
    //driverUid	INTEGER	否	司机uid
    private Long driverUid;
    //driverRecordId	INTEGER	否	商家发退货司机信息记录ID
    private Long driverRecordId;
    //driverName	STRING	是	司机姓名
    private String driverName;
    //plateNumber	STRING	是	车牌号
    private String plateNumber;
    //deliveryContactAreaNo	STRING	否	电话区号
    private String deliveryContactAreaNo;
}

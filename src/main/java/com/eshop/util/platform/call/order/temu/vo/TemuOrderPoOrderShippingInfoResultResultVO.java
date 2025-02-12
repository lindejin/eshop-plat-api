package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoOrderShippingInfoResultResultVO {

    //receiptName	STRING	否	收货人姓名
    private String receiptName;
    //mail	STRING	否	邮箱，目前透出为虚拟邮箱
    private String mail;
    //receiptAdditionalName	STRING	否	片假名
    private String receiptAdditionalName;
    //mobile	STRING	否	收货人手机号(虚拟号)，parentOrderStatus在待发货UN_SHIPPING、已发货SHIPPED）才会返回，格式为：11位手机号-4位分机号，形如："12312312312-1234"
    private String mobile;
    //backupMobile	STRING	否	备用电话，部分国家会有返回
    private String backupMobile;
    //regionName1	STRING	否	区域地址1，国家，如：United States
    private String regionName1;
    //regionName2	STRING	否	区域地址2，州，如NJ
    private String regionName2;
    //regionName3	STRING	否	区域地址3，城市，如Jersey City
    private String regionName3;
    //regionName4	STRING	否	区域地址4，日韩等国会有此区划
    private String regionName4;
    //addressLine1	STRING	否	详细地址行1，街道，如River Road
    private String addressLine1;
    //addressLine2	STRING	否	详细地址行2，详细地址，如APT2601
    private String addressLine2;
    //addressLine3	STRING	否	详细地址行3，部分国家会有返回
    private String addressLine3;
    //addressLineall	STRING	否	详细地址行1,详细地址行2，详细地址行3等
    private String addressLineall;
    //postCode	STRING	否	邮编地址
    private String postCode;
}

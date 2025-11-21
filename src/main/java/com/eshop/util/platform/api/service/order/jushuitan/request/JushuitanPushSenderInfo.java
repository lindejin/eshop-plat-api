package com.eshop.util.platform.api.service.order.jushuitan.request;

import lombok.Data;

@Data
public class JushuitanPushSenderInfo {
    //name
    //姓名
    //是
    //按奇门配置读取仓库或者店铺联系人信息
    //仓库名称、店铺简称、仓库联系人
    private String name;
    //mobile
    //移动电话
    //是
    //同上
    //店铺、云仓配置、仓库手机号
    private String mobile;
    //province
    //省
    //是
    //同上
    //店铺或仓库
    private String province;
    //city
    //市
    //是
    //同上
    //店铺或仓库
    private String city;
    //area
    //区
    //是
    //同上
    //店铺或仓库
    private String area;
    //detailAddress
    //详细地址
    //是
    //同上
    //店铺或仓库
    private String detailAddress;
}

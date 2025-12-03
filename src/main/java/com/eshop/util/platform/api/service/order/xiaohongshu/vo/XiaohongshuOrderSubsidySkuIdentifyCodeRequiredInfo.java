package com.eshop.util.platform.api.service.order.xiaohongshu.vo;

@lombok.Getter
@lombok.Setter
public class XiaohongshuOrderSubsidySkuIdentifyCodeRequiredInfo {

    //  snRequired	boolean	sn码是否必填
    //	barCodeRequired	boolean	barCode是否必填
    //	imei1Required	boolean	imei1码是否必填
    //	imei2Required	boolean	imei2码是否必填

    private Boolean snRequired;
    private Boolean barCodeRequired;
    private Boolean imei1Required;
    private Boolean imei2Required;

}

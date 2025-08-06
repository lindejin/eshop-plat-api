package com.eshop.util.platform.call.order.temu.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuFullLogisticsBoxMarkInfoReqDTO {

    /**
     * 发货单对象列表
     */
    private List<String> deliveryOrderSnList;

    //return_data_key	string	否	是否以打印页面url返回；
    //如果入参'true'，则不返回参数信息，返回dataKey，通过拼接https://openapi.kuajingmaihuo.com/tool/print?dataKey={返回的dataKey}，访问组装的url即可打印，打印的条码按照入参参数所得结果进行打印
    //其他情况，则返回参数信息，需要开发者自行对参数进行条形码组装
    private String return_data_key;
}

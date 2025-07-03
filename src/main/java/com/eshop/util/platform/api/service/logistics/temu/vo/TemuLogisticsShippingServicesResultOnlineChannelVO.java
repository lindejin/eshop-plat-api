package com.eshop.util.platform.api.service.logistics.temu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShippingServicesResultOnlineChannelVO {

    //channelId	LONG	Channel ID
    private Long channelId;
    //shipCompanyId	LONG	Ship Company ID
    private Long shipCompanyId;
    //shippingCompanyName	STRING	Shipping Company Name
    private String shippingCompanyName;
    //shipLogisticsType	STRING	Ship Logistics Type
    private String shipLogisticsType;
    //estimatedText	STRING	Estimated Text
    private String estimatedText;
    //estimatedCurrencyCode	STRING	Estimated Currency Code
    private String estimatedCurrencyCode;
    //estimatedAmount	STRING	Estimated Amount, Demo : $12.12
    private String estimatedAmount;
    //signServiceId	LONG	Unique Identifier for Signature Service
    private Long signServiceId;
    //signServiceName	STRING	Specifies the type of signature service to be used such as {Signature Confirmation,Restricted Delivery,Adult Signature Required,Adult Signature Restricted Delivery}.
    private String signServiceName;
    //infoNeeded	STRING[]	When placing an order through the channel, the parameter must be filled in.
    private List<String> infoNeeded;
    //payWayCode	INTEGER	payWayCode=1, means this channel can only fulfill PPD order payWayCode=2, means this channel can only fulfill COD order
    private Integer payWayCode;
}

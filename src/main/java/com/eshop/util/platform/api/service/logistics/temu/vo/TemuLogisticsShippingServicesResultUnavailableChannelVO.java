package com.eshop.util.platform.api.service.logistics.temu.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShippingServicesResultUnavailableChannelVO {

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
    //unavailableReason	STRING	The Reason why this shipLogisticsType is online but there is no available channel to fulfill this package.
    private String unavailableReason;

}

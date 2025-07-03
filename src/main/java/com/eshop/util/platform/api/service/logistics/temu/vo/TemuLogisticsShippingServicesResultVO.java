package com.eshop.util.platform.api.service.logistics.temu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShippingServicesResultVO {

    //onlineChannelDtoList	OBJECT[]	List of available shipping channels for this package.
    private List<TemuLogisticsShippingServicesResultOnlineChannelVO> onlineChannelDtoList;
    //unavailableChannelDtoList	OBJECT[]	List of online shipLogisticsType but not available for this package.
    private List<TemuLogisticsShippingServicesResultUnavailableChannelVO> unavailableChannelDtoList;

}

package com.eshop.util.platform.api.service.order.temu.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderPoOrderShippingInfoResultWarningV2VO {

    //isRestriction	BOOLEAN	isRestriction
    private Boolean isRestriction;
    //reason	INTEGER	When there is an address return restriction, it indicates the restriction scenario, which may be enumerated as follows: 1-COD, 2-Restricting self shipment, 3-promise only buy shipping.
    private Integer reason;
}

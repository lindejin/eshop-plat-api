package com.eshop.util.platform.api.service.order.temu.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderPoV2LogisticsShipmentConfirmSendRequestDTO {

    //carrierId	LONG	True	Carrier ID, it's the same ID with the logisticsServiceProviderId you got from "bg.logistics.companies.get".
    private Long carrierId;

    //trackingNumber	STRING	True	Tracking Number.
    private String trackingNumber;

    //selfShippingWarehouseId	STRING	False	The shipment warehouse ID can be obtained from the bg.logistics.warehouse.list.get interface.
    private String selfShippingWarehouseId;

    //orderSendInfoList	OBJECT[]	True	Product List in this package.
    private List<TemuOrderPoV2LogisticsShipmentConfirmSendInfoDTO> orderSendInfoList;

    //confirmAcceptance	STRING[]	False	Confirmation matters for this shipment,enumerated as follows: DENY_CANCELLATION: Reject the cancellation request for this order; DENY_ADDRESS_CHANGE: Reject the address change request for this order. DENY_PARENT_RISK_WARNING:Reject the risk warning for this order.
    private List<String> confirmAcceptance;

}

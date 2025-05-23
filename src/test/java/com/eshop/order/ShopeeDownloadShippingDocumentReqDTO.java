package com.eshop.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopeeDownloadShippingDocumentReqDTO {
    //Name	Type	Required	Sample	Description
    //shipping_document_type	string	False	NORMAL_AIR_WAYBILL	The type of shipping document. Available values: NORMAL_AIR_WAYBILL,THERMAL_AIR_WAYBILL,NORMAL_JOB_AIR_WAYBILL,THERMAL_JOB_AIR_WAYBILL
    private String shipping_document_type;
    //order_list	object[]	True		The list of orders you need to download it's shipping document.
    private List<ShopeeDownloadShippingDocumentItemDTO> order_list;

    //  order_sn	string	True	201118BCKPJQQ8	Shopee's unique identifier for an order.
    //  package_number	string	False	2485710696837122445	Shopee's unique identifier for the package under an order. You should't fill the field with empty string when there is't a package number.

}

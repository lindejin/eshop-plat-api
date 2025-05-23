package com.eshop.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopeeDownloadShippingDocumentItemDTO {
    //  order_sn	string	True	201118BCKPJQQ8	Shopee's unique identifier for an order.
    private String order_sn;
    //  package_number	string	False	2485710696837122445	Shopee's unique identifier for the package under an order. You should't fill the field with empty string when there is't a package number.
    private String package_number;
}

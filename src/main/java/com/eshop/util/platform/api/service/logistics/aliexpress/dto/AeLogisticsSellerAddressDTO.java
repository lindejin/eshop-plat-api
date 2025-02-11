package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 11:32
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsSellerAddressDTO {
    //request.addApiParameter("seller_address_query", "sender,pickup,refund");
    private String seller_address_query;
}

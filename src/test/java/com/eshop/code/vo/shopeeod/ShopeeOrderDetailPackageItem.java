package com.eshop.code.vo.shopeeod;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopeeOrderDetailPackageItem {
    /**
     * Shopee's unique identifier for the package under an order.
     */
    private String package_number;

    /**
     * The Shopee logistics status for the order. Applicable values: See Data Definition-LogisticsStatus.
     */
    private String logistics_status;

    /**
     * <p>The identity of logistic channel.</p>
     */
    private Long logistics_channel_id;

    /**
     * The logistics service provider that the buyer selected for the order to deliver items.
     */
    private String shipping_carrier;

    /**
     * <p>To indicate whether the package allows for self-designed AWB, if allow_self_design_awb returns false, it means that the package does not allow for self-designed AWB and only the system-AWB can be used.</p>
     */
    private Boolean allow_self_design_awb;

    /**
     * The lis of items.
     */
    private List<ShopeeOrderDetailPackageItemListItem> item_list;

    /**
     * display weight used to calculate ASF for this parcel
     */
    private Integer parcel_chargeable_weight;

    /**
     * <p>The common identifier for multiple orders combined in the same parcel.<br /></p>
     */
    private Long group_shipment_id;

    /**
     * <p>[Only for TW non-integrated channel] The virtual phone number to contact the recipient.<br /></p>
     */
    private String virtual_contact_number;

    /**
     * <p>[Only for TW non-integrated channel] The query number used in virtual phone number calls to contact the recipient of this package.<br /></p>
     */
    private String package_query_number;

}
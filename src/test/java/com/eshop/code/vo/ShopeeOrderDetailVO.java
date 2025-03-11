package com.eshop.code.vo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class ShopeeOrderDetailVO {

    /**
     * The identifier for an API request for error tracking.
     */
    private String request_id;

    /**
     * Indicate error type if hit error. Empty if no error happened.
     */
    private String error;

    /**
     * Indicate error details if hit error. Empty if no error happened.
     */
    private String message;

    /**
     * Detail informations you are querying.
     */
    private Response response;

    /**
     * Indicate warning message you should take care.
     */
    private List<String> warning;


    @Getter
    @Setter
    public static class Response {
        /**
         * The list of orders.
         */
        private List<OrderListItem> order_list;

    }

    @Getter
    @Setter
    public static class OrderListItem {
        /**
         * Return by default. Shopee's unique identifier for an order.	
         */
        private String order_sn;

        /**
         * Return by default. The two-digit code representing the region where the order was made.	
         */
        private String region;

        /**
         * Return by default. The three-digit code representing the currency unit for which the order was paid.	
         */
        private String currency;

        /**
         * Return by default. This value indicates whether the order was a COD (cash on delivery) order.	
         */
        private Boolean cod;

        /**
         * The total amount paid by the buyer for the order. This amount includes the total sale price of items, shipping cost beared by buyer; and offset by Shopee promotions if applicable. This value will only return after the buyer has completed payment for the order.	
         */
        private Float total_amount;

        /**
         * <p>The list of pending terms, possible values: SYSTEM_PENDING for order under Shopee internal processing, KYC_PENDING for order under KYC checking(TW CB order only)</p>
         */
        private List<String> pending_terms;

        /**
         * Return by default. Enumerated type that defines the current status of the order.	
         */
        private String order_status;

        /**
         * The logistics service provider that the buyer selected for the order to deliver items.	
         */
        private String shipping_carrier;

        /**
         * The payment method that the buyer selected to pay for the order. Applicable values: See Data Definition- Payment Methods.	
         */
        private String payment_method;

        /**
         * The estimated shipping fee is an estimation calculated by Shopee based on specific logistics courier's standard.	
         */
        private Float estimated_shipping_fee;

        /**
         * Return by default. Message to seller.	
         */
        private String message_to_seller;

        /**
         * Return by default. Timestamp that indicates the date and time that the order was created.	
         */
        private Timestamp create_time;

        /**
         * Return by default. Timestamp that indicates the last time that there was a change in value of order, such as order status changed from 'Paid' to 'Completed'.	
         */
        private Timestamp update_time;

        /**
         * Return by default. Shipping preparation time set by the seller when listing item on Shopee.	
         */
        private Integer days_to_ship;

        /**
         * Return by default. The deadline to ship out the parcel.	
         */
        private Integer ship_by_date;

        /**
         * <p>The user id of buyer of this order, will be empty if it is a non-integrated order in TW region.</p>
         */
        private Integer buyer_user_id;

        /**
         * <p>The name of buyer, will be masked as "****" if it is a non-integrated order in TW region.</p>
         */
        private String buyer_username;

        /**
         * <p>This object contains detailed breakdown for the recipient address.<br />Different parameters might be masked according to each market and kind of seller.<br /><br />For TW region integrated channel orders will be all masked as "****". More details may refer the announcement.<br /></p>
         */
        private RecipientAddress recipient_address;

        /**
         * The actual shipping fee of the order if available from external logistics partners.	
         */
        private Float actual_shipping_fee;

        /**
         * Only work for cross-border order.This value indicates whether the order contains goods that are required to declare at customs. "T" means true and it will mark as "T" on the shipping label; "F" means false and it will mark as "P" on the shipping label. This value is accurate ONLY AFTER the order trackingNo is generated, please capture this value AFTER your retrieve the trackingNo.	
         */
        private Boolean goods_to_declare;

        /**
         * The note seller made for own reference.	
         */
        private String note;

        /**
         * Update time for the note.	
         */
        private Timestamp note_update_time;

        /**
         * This object contains the detailed breakdown for the result of this API call.	
         */
        private List<ItemListItem> item_list;

        /**
         * The time when the order status is updated from UNPAID to PAID. This value is NULL when order is not paid yet.	
         */
        private Timestamp pay_time;

        /**
         * For Indonesia orders only. The name of the dropshipper.	
         */
        private String dropshipper;

        /**
         * The phone number of dropshipper, could be empty.
         */
        private String dropshipper_phone;

        /**
         * To indicate whether this order is split to fullfil order(forder) level. Call GetForderInfo if it's "true".	
         */
        private Boolean split_up;

        /**
         * Cancel reason from buyer, could be empty.
         */
        private String buyer_cancel_reason;

        /**
         * Could be one of buyer, seller, system or Ops.	
         */
        private String cancel_by;

        /**
         * Use this field to get reason for buyer, seller, and system cancellation.	
         */
        private String cancel_reason;

        /**
         * Use this filed to judge whether the actual_shipping_fee is confirmed.	
         */
        private Boolean actual_shipping_fee_confirmed;

        /**
         * Buyer's CPF number for taxation and invoice purposes. Only for Brazil order.	
         */
        private String buyer_cpf_id;

        /**
         * Use this field to indicate the order is fulfilled by shopee or seller. Applicable values: fulfilled_by_shopee, fulfilled_by_cb_seller, fulfilled_by_local_seller.	
         */
        private String fulfillment_flag;

        /**
         * The timestamp when pickup is done.
         */
        private Timestamp pickup_done_time;

        /**
         * The list of package under an order
         */
        private List<PackageListItem> package_list;

        /**
         * The invoice data of the order.
         */
        private InvoiceData invoice_data;

        /**
         * For non masking order, the logistics service provider that the buyer selected for the order to deliver items.  For masking order, the logistics service type that the buyer selected for the order to deliver items.
         */
        private String checkout_shipping_carrier;

        /**
         * Shopee charges the reverse shipping fee for the returned order.The value of this field will be non-negative.
         */
        private Float reverse_shipping_fee;

        /**
         * display weight used to calculate ASF for this order
         */
        private Integer order_chargeable_weight_gram;

        /**
         * <p>Return prescription images of this order, only for ID and PH whitelist sellers.</p><p><br /></p><p>Please add the prefix to review:</p><p>for ID:&nbsp;<a href="https://cf.shopee.co.id/file/+prescription_image" target="_blank" style="font-size:14px;">https://cf.shopee.co.id/file/+prescription_image</a></p><p>for PH:<a href="https://cf.shopee.co.id/file/+prescription_image" target="_blank" style="font-size:14px;">https://cf.shopee.ph/file/+prescription_image</a></p>
         */
        private List<String> prescription_images;

        /**
         * enum OrderPrescriptionCheckStatus: NONE = 0; PASSED = 1; FAILED = 2; Only for ID and PH whitelist sellers.
         */
        private Integer prescription_check_status;

        /**
         * <p>Earliest estimated delivery date of orders (only available for BR region)<br /></p>
         */
        private Timestamp edt_from;

        /**
         * <p>Latest estimated delivery time of orders (only available for BR region)<br /></p>
         */
        private Timestamp edt_to;

        /**
         * <p>Return by default. Shopee's unique identifier for a booking.</p><p>Only returned for advance fulfilment matched order only.</p>
         */
        private String booking_sn;

        /**
         * <p>Indicate whether order will be fulfilled using advance fulfilment stock or not. If value is true, order will be matched with a booking and seller should not arrange shipment.</p>
         */
        private Boolean advance_package;

        /**
         * <p>This field represents the deadline for buyers to initiate returns and refunds after order is completed.</p><p><br /></p><p>The “return_request_due_date” response parameter will be returned if the requested order meets&nbsp;<b>ALL&nbsp;the conditions</b>&nbsp;below:</p><p>- The status of the order is COMPLETED</p><p>- The return refund eligibility of the order is true</p><p><br /></p><p>If you have any questions related to the function of "returns and refunds after order is completed," please refer to the following link:&nbsp;https://seller.shopee.tw/edu/article/18474</p>
         */
        private Timestamp return_request_due_date;

    }

    @Getter
    @Setter
    public static class RecipientAddress {
        /**
         * Recipient's name for the address.	
         */
        private String name;

        /**
         * <p>Recipient's phone number input when order was placed.<br />[Only for TW non-integrated channel] Will return "****" when the "virtual_contact_number" is available<br /></p>
         */
        private String phone;

        /**
         *  The town of the recipient's address. Whether there is a town will depend on the region and/or country.	
         */
        private String town;

        /**
         * The district of the recipient's address. Whether there is a district will depend on the region and/or country.	
         */
        private String district;

        /**
         * The city of the recipient's address. Whether there is a city will depend on the region and/or country.	
         */
        private String city;

        /**
         * The state/province of the recipient's address. Whether there is a state/province will depend on the region and/or country.	
         */
        private String state;

        /**
         * The two-digit code representing the region of the Recipient.	
         */
        private String region;

        /**
         * Recipient's postal code.	
         */
        private String zipcode;

        /**
         * The full address of the recipient, including country, state, even street, and etc.	
         */
        private String full_address;

    }

    @Getter
    @Setter
    public static class ItemListItem {
        /**
         * Shopee's unique identifier for an item.
         */
        private Long item_id;

        /**
         * The name of the item.
         */
        private String item_name;

        /**
         *  A item SKU (stock keeping unit) is an identifier defined by a seller, sometimes called parent SKU. Item SKU can be assigned to an item in Shopee Listings.	
         */
        private String item_sku;

        /**
         * ID of the model that belongs to the same item.	
         */
        private Long model_id;

        /**
         * Name of the model that belongs to the same item. A seller can offer models of the same item. For example, the seller could create a fixed-priced listing for a t-shirt design and offer the shirt in different colors and sizes. In this case, each color and size combination is a separate model. Each model can have a different quantity and price.	
         */
        private String model_name;

        /**
         * A model SKU (stock keeping unit) is an identifier defined by a seller. It is only intended for the seller's use. Many sellers assign a SKU to an item of a specific type, size, and color, which are models of one item in Shopee Listings.	
         */
        private String model_sku;

        /**
         * The number of identical items purchased at the same time by the same buyer from one listing/item.	
         */
        private Integer model_quantity_purchased;

        /**
         * The original price of the item in the listing currency.	
         */
        private Float model_original_price;

        /**
         * The after-discount price of the item in the listing currency. If there is no discount, this value will be same as that of model_original_price. In case of bundle deal item, this value will return 0 as by design bundle deal discount will not be breakdown to item/model level. Due to technical restriction, the value will return the price before bundle deal if we don't configure it to 0. Please call GetEscrowDetails if you want to calculate item-level discounted price for bundle deal item.	
         */
        private Float model_discounted_price;

        /**
         * This value indicates whether buyer buy the order item in wholesale price.	
         */
        private Boolean wholesale;

        /**
         * The weight of the item	
         */
        private Float weight;

        /**
         * To indicate if this item belongs to an addon deal.	
         */
        private Boolean add_on_deal;

        /**
         * To indicate if this item is main item or sub item. True means main item, false means sub item.	
         */
        private Boolean main_item;

        /**
         * A unique ID to distinguish groups of items in Cart, and Order. (e.g. AddOnDeal)	
         */
        private Long add_on_deal_id;

        /**
         * <p>Available type：product_promotion, flash_sale, bundle_deal, add_on_deal_main, add_on_deal_sub.</p><p><br /></p><p>For items which attend multiple promotions will only show one promotion, the order of priority is:&nbsp;</p><p>bundle_deal &gt; add_on_deal_main &gt; add_on_deal_sub &gt; product_promotion &gt;flash_sale</p>
         */
        private String promotion_type;

        /**
         * The ID of the promotion.	
         */
        private Long promotion_id;

        /**
         * The identify of order item.
         */
        private Long order_item_id;

        /**
         * The identify of product promotion.
         */
        private Integer promotion_group_id;

        /**
         * Image info of the product.
         */
        private ImageInfo image_info;

        /**
         * The fulfilment warehouse ID(s) of the items in the order. (Multi-Warehouse sellers only)
         */
        private String product_location_id;

        /**
         * <p>To indicate if this item is prescription item<br /></p>
         */
        private Boolean is_prescription_item;

        /**
         * <p>determine if item is B2C_shop_item</p><p>It should be `<b>is_b2c_shop_item</b>` but it was a bug from dev. Then now it's <b>is_b2c_owned_item</b></p>
         */
        private Boolean is_b2c_owned_item;

    }

    @Getter
    @Setter
    public static class ImageInfo {
        /**
         * The image url of the product. Default to be variation image, if the model does not have a variation image, will use an item main image instead.
         */
        private String image_url;

    }

    @Getter
    @Setter
    public static class PackageListItem {
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
        private List<PackageItemListItem> item_list;

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

    @Getter
    @Setter
    public static class PackageItemListItem {
        /**
         * Shopee's unique identifier for an item.
         */
        private Long item_id;

        /**
         * Shopee's unique identifier for a model.
         */
        private Long model_id;

        /**
         * <p>The number of identical items/variations purchased at the same time by the same buyer from one listing/item.</p>
         */
        private Integer model_quantity;

        /**
         * <p>The identify of order item. For items in one same bundle deal promotion, the order_item_id should share the same id, such as 1,2. For items not in bundle deal promotion, the order_item_id should be the same as item_id.<br /></p>
         */
        private Long order_item_id;

        /**
         * <p>The identify of product promotion.<br /></p>
         */
        private Integer promotion_group_id;

        /**
         * <p>The warehouse ID of the item.<br /></p>
         */
        private String product_location_id;

    }

    @Getter
    @Setter
    public static class InvoiceData {
        /**
         * The number of the invoice.
         */
        private String number;

        /**
         * The series number of the invoice.
         */
        private String series_number;

        /**
         * The access key of the invoice.
         */
        private String access_key;

        /**
         * The issue date of the invoice.
         */
        private Timestamp issue_date;

        /**
         * The total value of the invoice.
         */
        private Float total_value;

        /**
         * The products total value of the invoice.
         */
        private Float products_total_value;

        /**
         * The tax code for the invoice.
         */
        private String tax_code;

    }

}
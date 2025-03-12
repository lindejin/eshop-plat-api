package com.eshop.code.vo.shopeeod;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public  class ShopeeOrderDetailItem {
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
    private BigDecimal total_amount;

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
    private BigDecimal estimated_shipping_fee;

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
    private ShopeeOrderDetailRecipientAddress recipient_address;

    /**
     * The actual shipping fee of the order if available from external logistics partners.
     */
    private BigDecimal actual_shipping_fee;

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
    private List<ShopeeOrderDetailItemListItem> item_list;

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
    private List<ShopeeOrderDetailPackageItem> package_list;

    /**
     * The invoice data of the order.
     */
    private ShopeeOrderDetailInvoiceData invoice_data;

    /**
     * For non masking order, the logistics service provider that the buyer selected for the order to deliver items.  For masking order, the logistics service type that the buyer selected for the order to deliver items.
     */
    private String checkout_shipping_carrier;

    /**
     * Shopee charges the reverse shipping fee for the returned order.The value of this field will be non-negative.
     */
    private BigDecimal reverse_shipping_fee;

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
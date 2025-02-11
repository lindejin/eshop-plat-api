package com.eshop.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/18 10:32
 * @Description: ...
 * @Version 1.0
 */
@Setter
@Getter
public class ShopeeOrderDetailReqDTO {
    //Request Parameters
    //Collapse
    //Name	Type	Required	Sample	Description
    //order_sn_list	string	True	201214JAJXU6G7,201214JASXYXY6	The set of order_sn. If there are multiple order_sn, you need to use English comma to connect them. limit [1,50]
    private String order_sn_list;
    //request_order_status_pending	boolean	False	true	Compatible parameter during migration period, send True will let API support PENDING status and return  pending_terms, send False or don’t send will fallback to old logic
    private Boolean request_order_status_pending;
    //response_optional_fields	string	False	total_amount	a response fields you want to get. Please select from the below response parameters. If you input an object field, all the params under it will be included automatically in the response. If there are multiple response fields you want to get, you need to use English comma to connect them. Available values: buyer_user_id,buyer_username,estimated_shipping_fee,recipient_address,actual_shipping_fee ,goods_to_declare,note,note_update_time,item_list,pay_time,dropshipper, dropshipper_phone,split_up,buyer_cancel_reason,cancel_by,cancel_reason,actual_shipping_fee_confirmed,buyer_cpf_id,fulfillment_flag,pickup_done_time,package_list,shipping_carrier,payment_method,total_amount,buyer_username,invoice_data,no_plastic_packing,order_chargeable_weight_gram,edt,return_due_date
    private String response_optional_fields;
}

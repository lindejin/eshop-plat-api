package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 17:12
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpPoSelfDeliveryDTO {
    //        request.addApiParameter("param0", "{\"return_type\":\"0\",\"appointment_license_plate\":\"\\\"\u6D59A6666\\\"\",\"purchase_order_no_list\":[\"[\\\"PON123456789\\\",\\\"PON223456789\\\"]\",\"[\\\"PON123456789\\\",\\\"PON223456789\\\"]\"],\"logistics_service_provider\":\"\\\"\u987A\u4E30\\\"\",\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\",\"return_contact_info_dto\":{\"area\":\"-\",\"address\":\"-\",\"phone\":\"-\",\"name\":\"-\",\"address_context\":\"{\\\"provCode\\\":\\\"110000\\\",\\\"areaCode\\\":\\\"110102\\\",\\\"cityCode\\\":\\\"110100\\\",\\\"prov\\\":\\\"\u5317\u4EAC\\\",\\\"city\\\":\\\"\u5317\u4EAC\u5E02\\\",\\\"area\\\":\\\"\u897F\u57CE\u533A\\\",\\\"addressDetail\\\":\\\"\u8BE6\u7EC6\u7684\u5730\u5740\\\"}\",\"area_id\":\"-\"},\"estimate_goods_volume\":\"1\",\"appointment_phone_number\":\"\\\"17112341234\\\"\",\"logistics_mark\":\"\\\"\u8FD9\u662F\u5907\u6CE8\\\"\",\"appointment_express_no_list\":[\"\\\"SF123456\\\"\",\"\\\"SF123456\\\"\"],\"self_delivery_scene_code\":\"\\\"JIT\\\"\",\"delivery_type\":\"\u9001\u4ED3\u65B9\u5F0F\"}");
    private String param0;
}

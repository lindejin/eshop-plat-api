package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 11:26
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsEstimateInsuranceDTO {
    //request.addApiParameter("agree_upgrade_reverse_parcel_insure", "true");
    //request.addApiParameter("trade_order_id", "400345345345");
    //request.addApiParameter("insurance_coverage", "4500");
    //request.addApiParameter("solution_code", "CAINIAO_STANDARD");
    private String agree_upgrade_reverse_parcel_insure;
    private String trade_order_id;
    private String insurance_coverage;
    private String solution_code;
}

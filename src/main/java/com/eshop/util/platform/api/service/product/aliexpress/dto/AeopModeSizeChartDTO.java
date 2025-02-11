package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/2 16:55
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopModeSizeChartDTO {
    //hips	String	否	臀围，厘米
    private String hips;
    //waist	String	否	腰围，厘米
    private String waist;
    //bust	String	否	胸围，厘米
    private String bust;
    //height	String	否	身高，厘米
    private String height;
    //mode_size	String	否	试穿尺码
    private String mode_size;
}

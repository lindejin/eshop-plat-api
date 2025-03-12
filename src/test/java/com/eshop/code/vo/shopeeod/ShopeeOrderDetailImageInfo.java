package com.eshop.code.vo.shopeeod;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopeeOrderDetailImageInfo {
    /**
     * The image url of the product. Default to be variation image, if the model does not have a variation image, will use an item main image instead.
     */
    private String image_url;

}

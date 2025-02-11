package com.eshop.util.platform.api.structure.shopee.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 虾皮店铺信息
 *
 * @author sheng
 * @date 2024-05-17 14:16
 **/
@Data
public class ShopeeVO implements Serializable {

    /**
     * 店铺Id
     */
    private String shopId;
    /**
     * 是否是CNSC店铺
     */
    private Boolean shopIsCnsc;
    /**
     * 附属店铺Id
     */
    private List<String> affiShopIds;
}

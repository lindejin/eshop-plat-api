package com.eshop.code.vo.shopeeod;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ShopeeOrderDetailItemListItem {
    /**
     * Shopee's unique identifier for an item.
     */
    private Long item_id;

    /**
     * The name of the item.
     */
    private String item_name;

    /**
     * A item SKU (stock keeping unit) is an identifier defined by a seller, sometimes called parent SKU. Item SKU can be assigned to an item in Shopee Listings.
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
    private BigDecimal model_original_price;

    /**
     * The after-discount price of the item in the listing currency. If there is no discount, this value will be same as that of model_original_price. In case of bundle deal item, this value will return 0 as by design bundle deal discount will not be breakdown to item/model level. Due to technical restriction, the value will return the price before bundle deal if we don't configure it to 0. Please call GetEscrowDetails if you want to calculate item-level discounted price for bundle deal item.
     */
    private BigDecimal model_discounted_price;

    /**
     * This value indicates whether buyer buy the order item in wholesale price.
     */
    private Boolean wholesale;

    /**
     * The weight of the item
     */
    private BigDecimal weight;

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
    private ShopeeOrderDetailImageInfo image_info;

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

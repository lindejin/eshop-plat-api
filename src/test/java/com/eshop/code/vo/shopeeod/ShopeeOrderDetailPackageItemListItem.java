package com.eshop.code.vo.shopeeod;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopeeOrderDetailPackageItemListItem {
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

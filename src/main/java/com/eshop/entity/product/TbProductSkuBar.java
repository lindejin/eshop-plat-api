package com.eshop.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 商品sku与第三方条码
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_product_sku_bar")
public class TbProductSkuBar implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 第三方条码内容
     */
    private String threeBarCode;

    /**
     * 第三方条码文件id
     */
    private Long threeBarImgId;
}

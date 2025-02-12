package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * Temu产品图片列表
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("temu_product_img")
public class TemuProductImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 平台图片ID
     */
    private Long fileImgId;

    /**
     * 场景类型： 1:货品轮播图, 2:多语言轮播图, 3:外包装图片,  4:素材图, 5:SKC轮播图, 6:SKC多语言轮播图
     */
    private Byte type;

    /**
     * 排序(序号为一的为主图)
     */
    private Byte sort;

    /**
     * 语言
     */
    private String language;

    /**
     * 商品skcId
     */
    private Long productSkcId;

    /**
     * temu平台图片Id
     */
    private String temuImgId;

    /**
     * temu平台图片Url
     */
    private String temuImgUrl;
}

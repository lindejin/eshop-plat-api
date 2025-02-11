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
 * TK产品图片列表
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tk_product_img")
public class TkProductImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 图片ID(tk平台)
     */
    private String imgId;

    /**
     * 图片Url(tk平台)
     */
    private String imgUrl;

    /**
     * 文件库图片ID
     */
    private Integer fileImgId;

    /**
     * 场景类型： 1.“产品图像” 2.“描述图像” 3.“属性图像” 4.“认证图像” 5.“尺寸图表图像”
     */
    private Byte imgScene;

    /**
     * 排序(序号为一的为主图)
     */
    private Byte sort;
}

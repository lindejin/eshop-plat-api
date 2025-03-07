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
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tk_tp_product_img")
public class TkTpProductImg implements Serializable {

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
     * 场景类型： 1.“产品图像” 2.“描述图像” 3.“属性图像” 4.“认证图像” 5.“尺寸图表图像”
     */
    private Byte imgScene;

    /**
     * 排序(序号为一的为主图)
     */
    private Byte sort;
}

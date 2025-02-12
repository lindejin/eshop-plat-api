package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 样机图片定位
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_prototype_img_clip")
public class TbPrototypeImgClip implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 样机图片_id
     */
    private Long prototypeImgId;

    /**
     * 定位名称
     */
    private String clipName;

    /**
     * 定位颜色
     */
    private String clipColor;

    /**
     * 定位宽度px
     */
    private BigDecimal clipWidth;

    /**
     * 定位高度px
     */
    private BigDecimal clipHeight;

    /**
     * 定位x轴位子px
     */
    private BigDecimal clipX;

    /**
     * 定位y轴位子px
     */
    private BigDecimal clipY;

    /**
     * 裁剪框定位及大小
     */
    private String cropBoxJson;
}

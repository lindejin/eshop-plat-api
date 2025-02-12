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
 * 图层定位
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("diy_img_layer_clip")
public class DiyImgLayerClip implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 图库主键id
     */
    private Long diyImgId;

    /**
     * 图层id
     */
    private Long layerId;

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
    private Double clipWidth;

    /**
     * 定位高度px
     */
    private Double clipHeight;

    /**
     * 定位x轴位子px
     */
    private Double clipX;

    /**
     * 定位y轴位子px
     */
    private Double clipY;

    /**
     * 裁剪框定位及大小
     */
    private String cropBoxJson;
}

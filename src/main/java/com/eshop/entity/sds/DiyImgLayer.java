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
 * 图库图层
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("diy_img_layer")
public class DiyImgLayer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图库主键id
     */
    private Integer diyImgId;

    /**
     * 图层顺序(例如: 图层顺序)
     */
    private Integer position;

    /**
     * 图层高度px
     */
    private Double width;

    /**
     * 图层宽度px
     */
    private Double height;

    /**
     * 旋转角度
     */
    private Byte angle;

    /**
     * 透明度(范围 0.0-1.0)
     */
    private Double opacity;

    /**
     * x轴坐标
     */
    private Double positionX;

    /**
     * y轴坐标
     */
    private Double positionY;

    /**
     * z轴坐标
     */
    private Double positionZ;

    /**
     * 是否可见(1: 是, 2: 否)
     */
    private Byte isVisibility;
}

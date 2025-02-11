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
 * 加工多面图
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_product_process_img")
public class TbProductProcessImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 定位名称
     */
    private String locationName;

    /**
     * 定位颜色
     */
    private String locationColor;

    /**
     * 效果图_id
     */
    private Integer resultImgId;

    /**
     * 素材_id
     */
    private Integer materialId;
}

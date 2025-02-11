package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 素材明细
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_material_detail")
public class TbMaterialDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 素材主表id
     */
    private Integer mainMaterialId;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * 文件库_id
     */
    private Integer fileId;

    /**
     * 素材来源(1: 直接上传, 2: 裁剪)
     */
    private Byte sourceType;

    /**
     * 素材宽度(px)
     */
    private BigDecimal materialWidth;

    /**
     * 素材高度(px)
     */
    private BigDecimal materialHeight;

    /**
     * 素材大小(字节 / b)
     */
    private Integer materialSize;

    /**
     * 可合并颜色
     */
    private String fitColour;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;
}

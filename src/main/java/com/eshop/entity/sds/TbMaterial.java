package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 素材
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_material")
public class TbMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 素材分类_id
     */
    private Long classifyId;

    /**
     * 文件库_id
     */
    private Long materialImgId;

    /**
     * 素材文件名称
     */
    private String materialName;

    /**
     * 素材备注/描述
     */
    private String materialRemark;

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
    private Long materialSize;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;
}

package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * sds-图片素材(产品 + 图片= 成品)	该表暂时没用，数据存储在tb_material等相关表
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("sds_layerimgs")
public class SdsLayerimgs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sds平台素材id
     */
    private Long layerimgId;

    /**
     * 颜色中文名称
     */
    private String name;

    /**
     * 颜色英文名称
     */
    private String nameEn;

    /**
     * 高
     */
    private Double height;

    /**
     * 宽
     */
    private Double width;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 删除时间
     */
    private Date updateTime;
}

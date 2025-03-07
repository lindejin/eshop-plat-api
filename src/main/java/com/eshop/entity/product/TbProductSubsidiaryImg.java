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
 * 主库附属图片
 * </p>
 *
 * @author product
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_product_subsidiary_img")
public class TbProductSubsidiaryImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 原图_id(文件表)
     */
    private Long rawImgId;

    /**
     * 附属图_id(文件表)
     */
    private Long subsidiaryImgId;

    /**
     * 附属类型(1: spu图, 2: 属性图/sku图, 3: 详情图)
     */
    private Byte subsidiaryType;
}

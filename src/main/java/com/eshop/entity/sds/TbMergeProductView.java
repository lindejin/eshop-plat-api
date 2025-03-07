package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_merge_product_view")
public class TbMergeProductView implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 类目id
     */
    private Long categoryId;

    /**
     * 商品分类id
     */
    private Long classifyId;

    /**
     * 数据来源类型(1: 主库录入, 2: 表格导入, 3: 第三方平台录入, 4: diy导入)
     */
    private Byte sourceType;

    /**
     * 商品状态(1/0/空: 未审核, 2: 已审核, -1: 作废)
     */
    private Byte productStatus;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 商品品牌id
     */
    private Long brandId;

    /**
     * 包材id
     */
    private Long packingId;

    /**
     * 开发员id
     */
    private Long developerId;

    /**
     * 原spu
     */
    private String rawSpu;

    /**
     * 创建人id
     */
    private Long creatorId;
}

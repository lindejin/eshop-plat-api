package com.eshop.entity.product;

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
 * 商品
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_product")
public class TbProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 类目id
     */
    private Long categoryId;

    /**
     * 商品分类id
     */
    private Long classifyId;

    /**
     * 供应链商品_id
     */
    private Long scmProductId;

    /**
     * 样机_id
     */
    private Long prototypeId;

    /**
     * 数据来源类型(1: 主库录入, 2: 表格导入, 3: 第三方平台录入, 4: diy导入, 5: 自动合成)
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
     * 是否共享(1: 是, 2:否)
     */
    private Byte isShare;

    /**
     * 原spu
     */
    private String rawSpu;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改人id
     */
    private Long lastUpdateId;

    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;
}

package com.eshop.entity.collect;

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
 * 采集商品
 * </p>
 *
 * @author collect
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("cl_product")
public class ClProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类类型(1: 私有, 2: 公有)
     */
    private Byte copyrightType;

    /**
     * 商户 id
     */
    private Long merchantId;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 标题
     */
    private String title;

    /**
     * 货币单位
     */
    private String currencyUnit;

    /**
     * 类目id
     */
    private Long categoryId;

    /**
     * 数据来源类型(1: 三方获取)
     */
    private Byte sourceType;

    /**
     * 数据来源url
     */
    private String sourceUrl;

    /**
     * 原spu
     */
    private String rawSpu;

    /**
     * 商品状态(1.未审核, 2: 已审核, -1: 作废)
     */
    private Byte productStatus;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否已认领(1,是 2.否(默认))
     */
    private Byte alreadyClaimed;
}

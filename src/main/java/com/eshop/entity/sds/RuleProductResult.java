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
 * 规则-结果基础信息
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("rule_product_result")
public class RuleProductResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 平台id
     */
    private Long platformId;

    /**
     * 商品id
     */
    private Long itemId;

    /**
     * 产品编号-对应sku
     */
    private String spuCode;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 阶段id
     */
    private Long stageId;

    /**
     * 商品对应规则分类配置id
     */
    private Long itemConfigId;

    /**
     * 结果信息ID
     */
    private Long basisInfoId;

    /**
     * 商品对应分配配置信息json格式
     */
    private String configText;

    /**
     * 状态1.未执行 2.已取消 3.执行中  4.执行成功 5.执行失败 6.没有匹配结果
     */
    private Long status;

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
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;
}

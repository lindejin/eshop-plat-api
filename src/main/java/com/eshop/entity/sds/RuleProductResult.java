package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 规则-结果基础信息
 * </p>
 *
 * @author sds
 * @since 2025-02-11
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
    private Integer id;

    /**
     * 平台id
     */
    private Integer platformId;

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
    private Integer shopId;

    /**
     * 阶段id
     */
    private Integer stageId;

    /**
     * 商品对应规则分类配置id
     */
    private Integer itemConfigId;

    /**
     * 结果信息ID
     */
    private Integer basisInfoId;

    /**
     * 商品对应分配配置信息json格式
     */
    private String configText;

    /**
     * 状态1.未执行 2.已取消 3.执行中  4.执行成功 5.执行失败 6.没有匹配结果
     */
    private Integer status;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Integer updateId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;
}

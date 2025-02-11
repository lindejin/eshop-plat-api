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
 * 规则-分项条件-规则配置表(可能多个  和阶段分项事件一对多)
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("rule_item_config")
public class RuleItemConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 平台id
     */
    private Integer platformId;

    /**
     * 店铺ID
     */
    private Integer shopId;

    /**
     * 阶段id
     */
    private Integer stageId;

    /**
     * 分析类型1.销售额 2.访客数 3.订单量 4.转化率 5.页面浏览量 6.加购数 7.加购率 8.买家数 9.商品评论数 10.产品点击率 11.展示次数页面
     */
    private Integer type;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 结果基础id
     */
    private Integer resultId;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
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

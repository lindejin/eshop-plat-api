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
 * 模版表
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("template_platform")
public class TemplatePlatform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 类目id
     */
    private String catePubId;

    /**
     * 背景id(a,b,c)
     */
    private String backgroupIds;

    /**
     * 素材id(a,b,c)
     */
    private String materialClassifyIds;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 变种比例
     */
    private Long proportion;

    /**
     * 最大上刊数量
     */
    private Long maxPrintCount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 创建者
     */
    private Long createId;

    /**
     * 更新者
     */
    private Long updateId;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}

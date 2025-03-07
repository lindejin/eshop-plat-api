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
 * sds-产品详情(产品 + 图片= 成品)
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("sds_product_detail")
public class SdsProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品id-原sds产品id
     */
    private Long productId;

    /**
     * 详情id
     */
    private Long detailId;

    /**
     * 温馨提醒
     */
    private String reminder;

    /**
     * 生产工艺
     */
    private String productionProcess;

    /**
     * 材质说明
     */
    private String materialDescription;

    /**
     * 产品性能
     */
    private String productPerformance;

    /**
     * 适用情景
     */
    private String applicableScenarios;

    /**
     * 洗涤说明
     */
    private String washingInstructions;

    /**
     * 特殊说明
     */
    private String specialDescription;

    /**
     * 设计说明
     */
    private String designExplanation;

    /**
     * 设计区域
     */
    private String designArea;

    /**
     * 图片要求
     */
    private String pictureRequest;

    /**
     * 产品尺码
     */
    private String productSize;

    /**
     * 包装规格
     */
    private String packagingSpecification;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}

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
 * 敦煌商品导入数据(原始)
 * </p>
 *
 * @author product
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("dh_product_template")
public class DhProductTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu编码(系统)
     */
    private String spuCode;

    /**
     * spu编码(原)
     */
    private String rawSpuCode;

    /**
     * 类目id
     */
    private String catePubId;

    /**
     * 类目名称
     */
    private String catePubName;

    /**
     * 类目属性
     */
    private String catePubAttributes;

    /**
     * 标题
     */
    private String title;

    /**
     * 关键词
     */
    private String keyWords;

    /**
     * 简短描述
     */
    private String shortContent;

    /**
     * 详描描述
     */
    private String htmlContent;

    /**
     * 货品重(kg)
     */
    private Double weight;

    /**
     * 长(cm)
     */
    private Double length;

    /**
     * 宽(cm)
     */
    private Double width;

    /**
     * 高(cm)
     */
    private Double height;

    /**
     * 备货数量
     */
    private Long inventoryNumber;

    /**
     * 备货期(天)
     */
    private Long leadingTime;

    /**
     * 服务模板
     */
    private String afterSaleTemplateName;

    /**
     * 运费模板
     */
    private String shippingModelName;

    /**
     * 计量单位
     */
    private String measureName;

    /**
     * 销售方式
     */
    private Byte saleStatus;

    /**
     * 价格区间销售数量
     */
    private String priceSaleNumber;

    /**
     * 价格区间折扣价格(或折扣比例)
     */
    private String discount;

    /**
     * 主图
     */
    private String mainPic;

    /**
     * 附图1
     */
    private String auxiliaryPic1;

    /**
     * 附图2
     */
    private String auxiliaryPic2;

    /**
     * 附图3
     */
    private String auxiliaryPic3;

    /**
     * 附图4
     */
    private String auxiliaryPic4;

    /**
     * 附图5
     */
    private String auxiliaryPic5;

    /**
     * 附图6
     */
    private String auxiliaryPic6;

    /**
     * 附图7
     */
    private String auxiliaryPic7;

    /**
     * 来源URL
     */
    private String sourceUrl;

    /**
     * 视频地址
     */
    private String videoUrl;

    /**
     * 推广图片地址
     */
    private String promotionalImage;
}

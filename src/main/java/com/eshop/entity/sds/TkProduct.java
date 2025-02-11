package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 虾皮商品
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tk_product")
public class TkProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 模版Id
     */
    private Integer templateId;

    /**
     * 类目id
     */
    private String catePubId;

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品状态(1.激活 2.停用)
     */
    private Byte productStatus;

    /**
     * 品牌id
     */
    private String brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 描述-需要确认大小
     */
    private String description;

    /**
     * 产品价格
     */
    private BigDecimal originalPrice;

    /**
     * 包装高度，单位为厘米
     */
    private Integer packageHeight;

    /**
     * 包装长度，单位为厘米
     */
    private Integer packageLength;

    /**
     * 包装宽度，单位为厘米
     */
    private Integer packageWidth;

    /**
     * 封装尺寸单位
     */
    private String packageDimensionUnit;

    /**
     * 重量
     */
    private BigDecimal packageWeight;

    /**
     * 是否打开货到付款(1.是 2.否)
     */
    private Byte isCodOpen;

    /**
     * 送货服务 ID
     */
    private String deliveryServiceIds;

    /**
     * 第三方产品的产品 ID
     */
    private String outerProductId;

    /**
     * 产品刊登错误信息
     */
    private String printErrMsg;

    /**
     * 用于错误跟踪的 API 请求的标识符
     */
    private String requestId;

    /**
     * 是否已刊登到店铺1: 是, 2: 否 3.仍需手动重新刊登
     */
    private Byte isPublish;

    /**
     * 是否执行过刊登 0.未执行过(默认) 1.执行过
     */
    private Byte isExecutedPublish;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 刊登时间
     */
    private LocalDateTime publicTime;

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
     * 商品类型(1:普通,2:全球)
     */
    private Byte productType;

    /**
     * 全球商品是否发布(1:已发布,2:未发布)
     */
    private Byte publishStatus;
}

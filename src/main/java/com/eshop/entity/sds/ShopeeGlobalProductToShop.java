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
 * 
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("shopee_global_product_to_shop")
public class ShopeeGlobalProductToShop implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

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
     * 店铺商户id
     */
    private Integer shopMerchantId;

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 产品名称
     */
    private String itemName;

    /**
     * 产品id
     */
    private Long itemId;

    /**
     * 全球产品id
     */
    private Long itemGlobalId;

    /**
     * 产品刊登错误信息
     */
    private String printErrMsg;

    /**
     * 刊登时间
     */
    private LocalDateTime publishTime;

    /**
     * 刊登失败原因
     */
    private String publishErrInfo;

    /**
     * 用于错误跟踪的 API 请求的标识符
     */
    private String requestId;

    /**
     * 是否已刊登到店铺1: 是, 2: 否 3.手动刊登
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
     * 创建人
     */
    private Integer createId;

    /**
     * 创建人
     */
    private Integer updateId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 全球产品任务id
     */
    private Long publishTaskId;
}

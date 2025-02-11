package com.eshop.entity.log;

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
 * 商铺授权日志
 * </p>
 *
 * @author log
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_shop_merchant_auth_log")
public class TbShopMerchantAuthLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 店铺商铺id
     */
    private Integer shopMerchantId;

    /**
     * 运行属性/运行描述
     */
    private String operateProperty;

    /**
     * 返回信息
     */
    private String description;

    /**
     * 操作人Id
     */
    private Integer operatorId;

    /**
     * 运行时间
     */
    private LocalDateTime operateTime;
}

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
 * 认领记录
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_product_claim_record")
public class TbProductClaimRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 平台_id
     */
    private String platformCode;

    /**
     * 主商品id / 成品id
     */
    private Integer mainProductId;

    /**
     * 主库产品编码
     */
    private String mainSpuCode;

    /**
     * 店铺_id
     */
    private Integer shopId;

    /**
     * 模板_id(非必填, 主库到子库,不一定要走模板)
     */
    private Integer templateId;

    /**
     * 子库商品_id
     */
    private Integer sonProductId;

    /**
     * 子库商品产品编码
     */
    private String sonSpuCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}

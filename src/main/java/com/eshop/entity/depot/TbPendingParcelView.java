package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_pending_parcel_view")
public class TbPendingParcelView implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 平台id
     */
    private Long platformId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 运单号/货运单号
     */
    private String waybillNo;

    /**
     * 物流方式/物流渠道
     */
    private Long logisticsModeId;

    /**
     * 付款时间
     */
    private Date orderTime;

    /**
     * 库存sku编号
     */
    private String productSku;

    /**
     * 数量
     */
    private Long number;

    /**
     * 包裹备注
     */
    private String remark;
}

package com.eshop.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 面单阶段下载
 * </p>
 *
 * @author order
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_waybill_label_download")
public class TbWaybillLabelDownload implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 平台id
     */
    private Long platformId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 包裹编号
     */
    private Long parcelNo;

    /**
     * 物流方式
     */
    private Long modeId;

    /**
     * 运单编号(货运单号)
     */
    private String waybillNo;

    /**
     * 下载状态（1等待 2待创建面单 3创建完成 4下载面单 5.完成）	
     */
    private Long downloadStatus;

    /**
     * 扩展字段1
     */
    private String ext1;

    /**
     * 扩展字段2
     */
    private String ext2;
}

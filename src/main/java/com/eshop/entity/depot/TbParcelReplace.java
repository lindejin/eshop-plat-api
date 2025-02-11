package com.eshop.entity.depot;

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
 * 包裹变更信息
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_parcel_replace")
public class TbParcelReplace implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 包裹号(原)
     */
    private Long rawParcelNo;

    /**
     * 运单号/货运单号(原)
     */
    private String rawWaybillNo;

    /**
     * 物流方式(原)
     */
    private Integer rawModeId;

    /**
     * 包裹号(新)
     */
    private Long newParcelNo;

    /**
     * 运单号/货运单号(新)
     */
    private String newWaybillNo;

    /**
     * 物流方式(新)
     */
    private Integer newModeId;

    /**
     * 替换原因
     */
    private String replaceCause;

    /**
     * 替换人id
     */
    private Integer replacePersonId;

    /**
     * 替换时间
     */
    private LocalDateTime replaceTime;

    /**
     * 替换状态(1:已替换,2:未替换)
     */
    private Byte replaceStatus;

    /**
     * 是否同步到第三方平台（0未替换，1已替换）
     */
    private Byte isSyn;
}

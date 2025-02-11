package com.eshop.entity.order;

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
 * 包裹运单号获取记录
 * </p>
 *
 * @author order
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_waybill_obtain_record")
public class TbWaybillObtainRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 运单号/货运单号
     */
    private String waybillNo;

    /**
     * 获取类型(1: 手动获取, 2: 自动获取)
     */
    private Byte obtainType;

    /**
     * 物流方式/物流渠道
     */
    private Integer logisticsModeId;

    /**
     * 运单状态(1: 正常, 2: 已过期)
     */
    private Byte waybillNoStatus;

    /**
     * 运单过期时间(单位:天)
     */
    private Integer waybillNoExpirationTime;

    /**
     * 获取操作人(1: 代表系统,  其他: 手动获取人)
     */
    private Integer obtainOperatorId;

    /**
     * 获取时间
     */
    private LocalDateTime obtainTime;

    /**
     * 过期时间
     */
    private LocalDateTime expirationTime;
}

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
 * 包裹打包
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_parcel_pack")
public class TbParcelPack implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次号
     */
    private Long batchNo;

    /**
     * 状态(1打包结束，2打包开始)
     */
    private Byte status;

    /**
     * 篮子编号
     */
    private Long basketCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 复核人
     */
    private Integer createId;

    /**
     * 打包时间
     */
    private LocalDateTime packTime;

    /**
     * 包裹类型(1:单品,2:多品)
     */
    private Byte parcelType;
}

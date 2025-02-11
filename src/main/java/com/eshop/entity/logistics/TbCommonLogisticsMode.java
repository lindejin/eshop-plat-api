package com.eshop.entity.logistics;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 共用_物流方式
 * </p>
 *
 * @author logistics
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_common_logistics_mode")
public class TbCommonLogisticsMode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 共用_物流服务商(一对多)
     */
    private Integer facilitatorId;

    /**
     * 渠道名称/物流名称
     */
    private String channeName;

    /**
     * 渠道类型
     */
    private String channelType;

    /**
     * 渠道代码
     */
    private String channelCode;

    /**
     * 是否允许导入自用,1:允许,2:不允许
     */
    private Byte channelStatus;

    /**
     * 备注
     */
    private String remark;
}

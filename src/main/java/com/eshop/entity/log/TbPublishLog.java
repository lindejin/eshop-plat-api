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
 * 刊登记录
 * </p>
 *
 * @author log
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_publish_log")
public class TbPublishLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 平台code
     */
    private String platformCode;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 刊登状态(1:成功: 2:失败)
     */
    private Byte publishStatus;

    /**
     * 描述
     */
    private String description;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 运行时间
     */
    private LocalDateTime operateTime;
}

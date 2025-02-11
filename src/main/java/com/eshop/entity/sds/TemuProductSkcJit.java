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
 * temu 全托JIT模式
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("temu_product_skc_jit")
public class TemuProductSkcJit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * skc_Id
     */
    private Integer temuProductSkcId;

    /**
     * 全托JIT模式状态: 1:待开启, 2:待签署预售规则, 3.签署成功,待设置库存, 4:库存设置成功
     */
    private Byte jitStatus;

    /**
     * 异常信息
     */
    private String errMsg;

    /**
     * 用于错误跟踪的 API 请求的标识符
     */
    private String requestId;

    /**
     * 虚拟库存
     */
    private Integer virtualStock;

    /**
     * 预览图
     */
    private Integer thumbId;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Integer updateId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}

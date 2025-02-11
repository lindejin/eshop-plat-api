package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * Temu模版视频列表
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("temu_tp_video")
public class TemuTpVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模版id
     */
    private Integer productId;

    /**
     * 文件库ID
     */
    private Integer fileVideoId;

    /**
     * 排序(序号为一的为主图)
     */
    private Byte sort;

    /**
     * 视频类型: 1:主图视频,2:详情视频
     */
    private Byte type;
}

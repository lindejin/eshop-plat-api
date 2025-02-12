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
 * 虾皮产品视频列表
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tk_product_video")
public class TkProductVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 视频URL(tk平台)
     */
    private String videoUrl;

    /**
     * 视频ID(tk平台)
     */
    private String videoId;

    /**
     * 平台视屏ID
     */
    private String fileVideoId;

    /**
     * 排序(序号为一的为主图)
     */
    private Byte sort;
}

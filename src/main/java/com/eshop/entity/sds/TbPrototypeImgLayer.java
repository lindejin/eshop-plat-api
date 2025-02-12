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
 * 模特图图层
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_prototype_img_layer")
public class TbPrototypeImgLayer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 样机id
     */
    private Long prototypeId;

    /**
     * 样机图片_id
     */
    private Long prototypeImgId;

    /**
     * 图层文件id
     */
    private Long imgId;

    /**
     * 排序
     */
    private Byte sort;
}

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
 * Temu产品模版 文件相关信息
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("temu_tp_product_file")
public class TemuTpProductFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品模板Id
     */
    private Integer productId;

    /**
     * SKC色块图 Id	SKC色块图Id
     */
    private Integer colorImageUrlId;

    /**
     * 文件类型: 1:敏感品转普证明文件 ,2:货品说明书文件
     */
    private Byte type;

    /**
     * 文件Id
     */
    private Integer fileId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 语言 多个以逗号隔开
     */
    private String languages;
}

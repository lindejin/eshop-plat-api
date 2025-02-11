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
 * 素材
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_material")
public class TbMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户_id
     */
    private Integer merchantId;

    /**
     * 素材编码
     */
    private String spuCode;

    /**
     * 素材分类_id
     */
    private Integer classifyId;

    /**
     * 素材类型(1: 图片, 2: 视频)
     */
    private Byte materialType;

    /**
     * 分类类型(1: 私有, 2: 公有)
     */
    private Byte copyrightType;

    /**
     * 素材名称
     */
    private String materialName;

    /**
     * 素材备注/描述
     */
    private String materialRemark;

    /**
     * 第三方_id
     */
    private Integer thirdPartyId;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;
}

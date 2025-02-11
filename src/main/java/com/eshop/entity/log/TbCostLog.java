package com.eshop.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 费用运行日志
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_cost_log")
public class TbCostLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 运行属性/运行描述
     */
    private String operateProperty;

    /**
     * 描述
     */
    private String description;

    /**
     * 更新前费用cost_json
     */
    private String rawCostJson;

    /**
     * 更新后费用updated_cost_json
     */
    private String updatedCostJson;

    /**
     * 业务id biz_id
     */
    private String bizId;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 运行时间
     */
    private LocalDateTime operateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperateProperty() {
        return operateProperty;
    }

    public void setOperateProperty(String operateProperty) {
        this.operateProperty = operateProperty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRawCostJson() {
        return rawCostJson;
    }

    public void setRawCostJson(String rawCostJson) {
        this.rawCostJson = rawCostJson;
    }

    public String getUpdatedCostJson() {
        return updatedCostJson;
    }

    public void setUpdatedCostJson(String updatedCostJson) {
        this.updatedCostJson = updatedCostJson;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public String toString() {
        return "TbCostLog{" +
        ", id = " + id +
        ", operateProperty = " + operateProperty +
        ", description = " + description +
        ", rawCostJson = " + rawCostJson +
        ", updatedCostJson = " + updatedCostJson +
        ", bizId = " + bizId +
        ", operator = " + operator +
        ", operateTime = " + operateTime +
        "}";
    }
}

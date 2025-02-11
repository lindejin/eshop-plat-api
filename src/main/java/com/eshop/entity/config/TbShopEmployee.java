package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 店铺与用户(中间表)
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_shop_employee")
public class TbShopEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer tbShopId;

    /**
     * 员工id
     */
    private Integer employeeId;

    /**
     * 员工名称
     */
    private String employeeName;

    /**
     * 员工类型(0表示店长、1表示店员、2表示客服)
     */
    private Byte employeeType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private Integer createOperId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTbShopId() {
        return tbShopId;
    }

    public void setTbShopId(Integer tbShopId) {
        this.tbShopId = tbShopId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Byte getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Byte employeeType) {
        this.employeeType = employeeType;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(Integer createOperId) {
        this.createOperId = createOperId;
    }

    @Override
    public String toString() {
        return "TbShopEmployee{" +
        ", id = " + id +
        ", tbShopId = " + tbShopId +
        ", employeeId = " + employeeId +
        ", employeeName = " + employeeName +
        ", employeeType = " + employeeType +
        ", createTime = " + createTime +
        ", createOperId = " + createOperId +
        "}";
    }
}

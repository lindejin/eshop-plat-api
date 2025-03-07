package com.eshop.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 用户日志表
 * </p>
 *
 * @author log
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_employee_log")
public class TbEmployeeLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登陆人
     */
    private Long employeeId;

    /**
     * 登录人名字
     */
    private String employeeName;

    /**
     * 日志标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * IP
     */
    private String ip;

    /**
     * User-Agent
     */
    private String useragent;

    /**
     * 操作时间
     */
    private Date createtime;
}

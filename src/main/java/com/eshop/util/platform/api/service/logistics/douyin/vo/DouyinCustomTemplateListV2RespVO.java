package com.eshop.util.platform.api.service.logistics.douyin.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-28 22:38
 **/
@lombok.Getter
@lombok.Setter
public class DouyinCustomTemplateListV2RespVO extends BaseResponseVO {
    //字段名称 类型 说明
    //------------ -------- ----------------------------------------------------------------------

    //code Number 主错误码：code=10000 调用成功；code!=10000 调用失败，具体错误码参见下表
    private Integer code;
    //msg String 主错误信息
    private String msg;
    //sub_code String 子错误码
    private String sub_code;
    //sub_msg String 子错误信息
    private String sub_msg;
    //log_id String 每一条日志的唯一标识
    private String log_id;

    //err_no Number 【即将废弃】老版错误码：err_no=0 调用成功；err_no!=0 调用失败
    //message String 【即将废弃】老版错误信息

    //data String 具体业务信息，json格式
    private DouyinCustomTemplateDataResultVO data;
}


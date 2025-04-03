package com.eshop.util.minio;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Data
@Slf4j
//@ApiModel(value = "RetCode")
public class RetCode<T> {


    //@ApiModelProperty(name = "ack", value = "0、成功；2、失败")
    private int ack;

    //@ApiModelProperty(name = "msg", value = "错误描述")
    private String msg;

    //@ApiModelProperty(name = "data", value = "返回的数据")
    private T data;

    //@ApiModelProperty(name = "datas", value = "返回的数据,集合")
    private List<T> datas;

    //@ApiModelProperty(name = "pop", value = "返回的额外数据")
    private Object pop;

    public static RetCode ok(String msg) {
        RetCode<String> ret = new RetCode<>();
        ret.setAck(0);
        ret.setMsg(msg);
        return ret;
    }

    public static RetCode ok(String msg,int ack) {
        RetCode<String> ret = new RetCode<>();
        ret.setAck(ack);
        ret.setMsg(msg);
        return ret;
    }

    public static <T> RetCode ok(String msg, List<T> datas) {
        RetCode<T> ret = new RetCode<>();
        ret.setAck(0);
        ret.setMsg(msg);
        ret.setDatas(datas);
        return ret;
    }
    public static <T> RetCode ok(String msg, List<T> datas,Object pop) {
        RetCode<T> ret = new RetCode<>();
        ret.setAck(0);
        ret.setMsg(msg);
        ret.setDatas(datas);
        ret.setPop(pop);
        return ret;
    }


    public static <T> RetCode ok(String msg, T data) {
        RetCode<T> ret = new RetCode<>();
        ret.setAck(0);
        ret.setMsg(msg);
        ret.setData(data);
        return ret;
    }

    public static RetCode exception(String msg) {
        RetCode<String> ret = new RetCode<>();
        ret.setAck(1000);
        ret.setMsg(msg);
        return ret;
    }
    public static RetCode err(String msg) {
        RetCode<String> ret = new RetCode<>();
        ret.setAck(1);
        ret.setMsg(msg);
        return ret;
    }

    public static <T> RetCode err(String msg, T data) {
        RetCode<T> ret = new RetCode<>();
        ret.setAck(1);
        ret.setMsg(msg);
        ret.setData(data);
        return ret;
    }
}

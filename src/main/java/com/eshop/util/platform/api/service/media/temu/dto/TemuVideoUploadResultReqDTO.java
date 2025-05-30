package com.eshop.util.platform.api.service.media.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoUploadResultReqDTO {
    //参数名称	参数类型	是否必须	说明
    //request 	OBJECT 	是
    //  vid 	STRING 	是 	接口2或者接口5返回的视频vid
    private String vid;
}

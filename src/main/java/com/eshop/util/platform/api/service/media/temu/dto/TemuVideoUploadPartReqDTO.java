package com.eshop.util.platform.api.service.media.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoUploadPartReqDTO {

    //参数名称	类型	是否必须	说明
    //part_file 	File 	是 	视频分片文件
    //content_md5 	String 	否 	文件MD5值，用于校验实际收到的数据和发起方本地的数据是否一致
    private String content_md5;
    //sign 	String 	是 	3中获取的文件上传Sign
    private String sign;
    //part_num 	String 	是 	当前分片编号名，从1开始
    private String part_num;

}

package com.eshop.util.platform.api.service.media.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuVideoUploadPartRespVO extends BaseResponseVO {

    //参数名称	类型	是否必须	说明
    //uploaded_part_num 	int 	是 	表示本次成功上传的part number
    private Integer uploaded_part_num;
    /**
     * 成功时不返回
     */
    private Integer error_code;

    /**
     * 错误消息
     */
    private String error_msg;
}

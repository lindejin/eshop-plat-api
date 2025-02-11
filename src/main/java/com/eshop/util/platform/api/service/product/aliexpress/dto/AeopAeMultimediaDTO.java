package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ldj
 * @date 2024/3/2 16:39
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAeMultimediaDTO {
    //名称	类型	是否必须	描述
    //aeop_a_e_videos	Object[]	否	主图视频，只允许一个
    private List<AeopAeVideoDTO> aeop_a_e_videos;
}

package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductCarouseVideoReqDTO {

    //vid	STRING	是	视频VID
    //coverUrl	STRING	是	视频封面图(B端存储的是首侦图)
    //videoUrl	STRING	是	视频url
    //width	INTEGER	是	视频宽度
    //height	INTEGER	是	视频高度

    private String vid;
    private String coverUrl;
    private String videoUrl;
    private Long width;
    private Long height;
}

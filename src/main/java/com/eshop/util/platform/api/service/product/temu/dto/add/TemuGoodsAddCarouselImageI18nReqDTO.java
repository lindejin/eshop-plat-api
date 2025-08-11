package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddCarouselImageI18nReqDTO {

    //imgUrlList	LIST	否	图片列表
    //language	STRING	是	语言

    private List<String> imgUrlList;
    private String language;
}

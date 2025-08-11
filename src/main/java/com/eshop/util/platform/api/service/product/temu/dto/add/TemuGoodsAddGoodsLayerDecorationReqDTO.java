package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddGoodsLayerDecorationReqDTO {

    //floorId	INTEGER	否	楼层id,null:新增,否则为更新
    //goodsId	INTEGER	否	商品ID
    //lang	STRING	是	语言类型
    //type	STRING	是	组件类型type,图片-image,文本-text
    //priority	INTEGER	是	楼层排序
    //contentList	LIST	是	楼层内容
    //key	STRING	是	楼层类型的key,目前默认传'DecImage'

    private Long floorId;
    private Long goodsId;
    private String lang;
    private String type;
    private Long priority;
    private List<TemuGoodsAddGoodsLayerDecorationContentReqDTO> contentList;
    private String key;
}

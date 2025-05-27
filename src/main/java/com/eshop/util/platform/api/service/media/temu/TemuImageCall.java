package com.eshop.util.platform.api.service.media.temu;

import com.eshop.util.platform.api.service.media.temu.dto.TemuGoodsTextToPictureAddReqDTO;
import com.eshop.util.platform.api.service.media.temu.vo.TemuGoodsTextToPictureAddRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuImageCall {


    /**
     * bg.goods.texttopicture.add
     * 文字转图片
     * 更新时间：2025-03-04 17:37:22
     * 接口介绍：文字转图片
     * CN
     */
    TemuGoodsTextToPictureAddRespVO goodsTextToPictureAdd(TemuAppClientDTO temuAcDTO, TemuGoodsTextToPictureAddReqDTO reqDTO) throws Exception;

}

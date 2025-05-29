package com.eshop.util.platform.api.service.media.temu;

import com.eshop.util.platform.api.service.media.temu.dto.TemuImageUploadReqDTO;
import com.eshop.util.platform.api.service.media.temu.dto.TemuGoodsTextToPictureAddReqDTO;
import com.eshop.util.platform.api.service.media.temu.vo.TemuGoodsImageUploadRespVO;
import com.eshop.util.platform.api.service.media.temu.vo.TemuGoodsTextToPictureAddRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuImageCall {
    /**
     * bg.goods.image.upload
     * bas64图片上传
     * 更新时间：2025-03-04 17:25:05
     * 接口介绍：图片上传接口
     * CN
     */
    TemuGoodsImageUploadRespVO goodsImageUpload(TemuAppClientDTO temuAcDTO, TemuImageUploadReqDTO reqDTO) throws Exception;


    /**
     * bg.goods.texttopicture.add
     * 文字转图片
     * 更新时间：2025-03-04 17:37:22
     * 接口介绍：文字转图片
     * CN
     */
    TemuGoodsTextToPictureAddRespVO goodsTextToPictureAdd(TemuAppClientDTO temuAcDTO, TemuGoodsTextToPictureAddReqDTO reqDTO) throws Exception;

}

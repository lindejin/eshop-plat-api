package com.eshop.util.platform.api.service.media.temu;

import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.service.media.temu.dto.TemuGoodsTextToPictureAddReqDTO;
import com.eshop.util.platform.api.service.media.temu.dto.TemuImageUploadReqDTO;
import com.eshop.util.platform.api.service.media.temu.vo.TemuGoodsImageUploadRespVO;
import com.eshop.util.platform.api.service.media.temu.vo.TemuGoodsImageUploadResultVO;
import com.eshop.util.platform.api.service.media.temu.vo.TemuGoodsTextToPictureAddRespVO;
import com.eshop.util.platform.api.service.media.temu.vo.TemuGoodsTextToPictureAddResultVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Slf4j
@Service
public class TemuImageCallImpl implements TemuImageCall {

    @Resource
    private TemuApiInvoker temuApiInvoker;

    @Override
    public TemuGoodsImageUploadRespVO goodsImageUpload(TemuAppClientDTO temuAcDTO, TemuImageUploadReqDTO reqDTO) throws Exception {
        String type = "bg.goods.image.upload";
        TemuGoodsImageUploadRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuGoodsImageUploadRespVO.class,
                reqDTO
        );
        TemuGoodsImageUploadResultVO resultVO = respVO.getResult();
        if (resultVO != null) {
            respVO.setImageUrl(resultVO.getImageUrl());
            respVO.setUrl(resultVO.getUrl());
            respVO.setUrls(resultVO.getUrls());
        }
        return respVO;
    }

    @Override
    public TemuGoodsTextToPictureAddRespVO goodsTextToPictureAdd(TemuAppClientDTO temuAcDTO, TemuGoodsTextToPictureAddReqDTO reqDTO) throws Exception {
        String type = "bg.goods.texttopicture.add";
        TemuGoodsTextToPictureAddRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuGoodsTextToPictureAddRespVO.class,
                reqDTO
        );

        String imageUrl = Optional.ofNullable(respVO.getResult()).map(TemuGoodsTextToPictureAddResultVO::getImageUrl).orElse(null);
        respVO.setImageUrl(imageUrl);
        return respVO;
    }
}

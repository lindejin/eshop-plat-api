package com.eshop.util.platform.api.service.media.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.client.temu.TemuClient;
import com.eshop.util.platform.api.client.temu.TemuFileRequest;
import com.eshop.util.platform.api.client.temu.TemuResponse;
import com.eshop.util.platform.api.service.media.temu.dto.*;
import com.eshop.util.platform.api.service.media.temu.vo.*;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.utils.FastJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TemuVideoCallImpl implements TemuVideoCall {

    @Resource
    private TemuApiInvoker temuApiInvoker;

    @Resource
    private TemuClient temuClient;

    @Override
    public TemuVideoUploadSignRespVO goodsVideoUploadSignGet(TemuAppClientDTO temuAcDTO, TemuVideoUploadSignReqDTO reqDTO) throws Exception {
        String type = "bg.goods.video.upload.sign.get";
        TemuVideoUploadSignRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuVideoUploadSignRespVO.class,
                reqDTO
        );
        TemuVideoUploadSignResultVO result = respVO.getResult();
        if (result != null) {
            respVO.setSign(result.getSign());
        }
        return respVO;
    }

    @Override
    public TemuVideoUploadResultRespVO goodsBigVideoUploadResultGet(TemuAppClientDTO temuAcDTO, TemuVideoUploadResultReqDTO reqDTO) throws Exception {
        String type = "bg.goods.big.video.upload.result.get";
        TemuVideoUploadResultRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuVideoUploadResultRespVO.class,
                reqDTO
        );

        TemuVideoUploadResultVO result = respVO.getResult();
        if (result != null) {
            respVO.setVid(result.getVid());
            respVO.setCoverUrl(result.getCoverUrl());
            respVO.setVideoUrl(result.getVideoUrl());
            respVO.setWidth(result.getWidth());
            respVO.setHeight(result.getHeight());
        }
        return respVO;
    }


    @Override
    public TemuVideoStoreVideoUploadRespVO uploadStoreVideo(
            byte[] byteFile,
            String fileParam,
            String fileName,
            TemuVideoStoreVideoUploadReqDTO reqDTO
    ) throws Exception {
        String url = "https://openapi.kuajingmaihuo.com/api/galerie/v1/store_video";
        TemuFileRequest request = new TemuFileRequest();
        request.setUrl(url);
        request.setByteFile(byteFile);
        request.setFileParam(fileParam);
        request.setFileName(fileName);
        request.setJsonParams(FastJsonUtil.toJsonToJsonObj(reqDTO));
        TemuResponse temuResponse = temuClient.executeUpload(request);

        String respBody = temuResponse.getGopResponseBody();
        TemuVideoStoreVideoUploadRespVO respVO = JSONObject.parseObject(respBody, TemuVideoStoreVideoUploadRespVO.class);
        if (respVO == null) {
            respVO = new TemuVideoStoreVideoUploadRespVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }

    @Override
    public TemuVideoInitRespVO initVideoUpload(TemuVideoInitReqDTO reqDTO) throws Exception {
        String url = "https://openapi.kuajingmaihuo.com/api/galerie/large_file/v1/video/upload_init";
        TemuFileRequest request = new TemuFileRequest();
        request.setUrl(url);
        request.setJsonParams(FastJsonUtil.toJsonToJsonObj(reqDTO));
        TemuResponse temuResponse = temuClient.executeUploadPost(request);

        String respBody = temuResponse.getGopResponseBody();
        TemuVideoInitRespVO respVO = JSONObject.parseObject(respBody, TemuVideoInitRespVO.class);
        if (respVO == null) {
            respVO = new TemuVideoInitRespVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }

    @Override
    public TemuVideoUploadPartRespVO uploadVideoPart(
            byte[] byteFile,
            String fileParam,
            String fileName,
            TemuVideoUploadPartReqDTO reqDTO
    ) throws Exception {
        String url = "https://openapi.kuajingmaihuo.com/api/galerie/large_file/v1/video/upload_part";
        TemuFileRequest request = new TemuFileRequest();
        request.setUrl(url);
        request.setByteFile(byteFile);
        request.setFileParam(fileParam);
        request.setFileName(fileName);
        request.setJsonParams(FastJsonUtil.toJsonToJsonObj(reqDTO));
        TemuResponse temuResponse = temuClient.executeUpload(request);

        String respBody = temuResponse.getGopResponseBody();
        TemuVideoUploadPartRespVO respVO = JSONObject.parseObject(respBody, TemuVideoUploadPartRespVO.class);
        if (respVO == null) {
            respVO = new TemuVideoUploadPartRespVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }

    @Override
    public TemuVideoUploadCompleteRespVO completeVideoUpload(TemuVideoUploadCompleteReqDTO reqDTO) throws Exception {
        String url = "https://openapi.kuajingmaihuo.com/api/galerie/large_file/v1/video/upload_complete";
        TemuFileRequest request = new TemuFileRequest();
        request.setUrl(url);
        request.setJsonParams(FastJsonUtil.toJsonToJsonObj(reqDTO));
        TemuResponse temuResponse = temuClient.executeUploadPost(request);

        String respBody = temuResponse.getGopResponseBody();
        TemuVideoUploadCompleteRespVO respVO = JSONObject.parseObject(respBody, TemuVideoUploadCompleteRespVO.class);
        if (respVO == null) {
            respVO = new TemuVideoUploadCompleteRespVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }

}

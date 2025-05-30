package com.eshop.util.platform.api.service.media.temu;

import com.eshop.util.platform.api.service.media.temu.dto.*;
import com.eshop.util.platform.api.service.media.temu.vo.*;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

import java.io.InputStream;

public interface TemuVideoCall {
    /**
     * bg.goods.video.upload.sign.get
     * 查询视频上传sign接口
     * 更新时间：2025-03-04 17:53:07
     * 接口介绍：视频文件上传sign查询
     * CN
     */
    TemuVideoUploadSignRespVO goodsVideoUploadSignGet(
            TemuAppClientDTO temuAcDTO,
            TemuVideoUploadSignReqDTO reqDTO
    ) throws Exception;

    /**
     * bg.goods.big.video.upload.result.get
     * 查询视频转码结果接口
     * 更新时间：2025-03-04 17:54:09
     * 接口介绍：查询视频转码结果接口
     * CN
     */
    TemuVideoUploadResultRespVO goodsBigVideoUploadResultGet(
            TemuAppClientDTO temuAcDTO,
            TemuVideoUploadResultReqDTO reqDTO
    ) throws Exception;

    /**
     * 小文件视频直传
     * 适用文件：≤20MB
     * 上传地址：/galerie/v1/store_video
     * 20MB以下视频上传
     * https://openapi.kuajingmaihuo.com/api/galerie/v1/store_video
     */
    TemuVideoStoreVideoUploadRespVO uploadStoreVideo(
            byte[] byteFile,
            String fileParam,
            String fileName,
            TemuVideoStoreVideoUploadReqDTO uploadReqDTO
    ) throws Exception;

    /**
     * 大文件上传初始化
     * 适用文件：＞20MB
     * 上传地址：/galerie/large_file/v1/video/upload_init
     * <p>
     * 20MB以上视频上传初始化
     * https://openapi.kuajingmaihuo.com/api/galerie/large_file/v1/video/upload_init
     */
    TemuVideoInitRespVO initVideoUpload(
            TemuVideoInitReqDTO initReqDTO
    ) throws Exception;

    /**
     * 分片上传执行
     * 分片大小：建议小于20MB
     * 上传地址：/galerie/large_file/v1/video/upload_part
     * 20MB以上视频分片上传
     * https://openapi.kuajingmaihuo.com/api/galerie/large_file/v1/video/upload_part
     */
    TemuVideoUploadPartRespVO uploadVideoPart(
            byte[] partFile,
            String fileParam,
            String fileName,
            TemuVideoUploadPartReqDTO partReqDTO
    ) throws Exception;

    /**
     * 分片上传完成
     * 功能：合并分片完成上传
     * 上传地址：/galerie/large_file/v1/video/upload_complete
     * 20MB以上视频分片上传完成接口
     * https://openapi.kuajingmaihuo.com/api/galerie/large_file/v1/video/upload_complete
     */
    TemuVideoUploadCompleteRespVO completeVideoUpload(
            TemuVideoUploadCompleteReqDTO completeReqDTO
    ) throws Exception;
}

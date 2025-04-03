package com.eshop.util.minio.service;

import com.eshop.util.minio.ImgInfo;
import io.minio.messages.DeleteObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/**
 * 文件上传接口
 * 
 * @author rch
 */
public interface ISysFileService
{
    /**
     * 文件上传接口
     * 
     * @param file 上传的文件 MultipartFile类型
     * @param filePathType  见配置文件
     * @param contentType 文件类型
     * @return 访问地址
     * @throws Exception
     */
    public String uploadMultipartFile(MultipartFile file, Integer filePathType, String contentType) throws Exception;


    /**
     * 文件接口上传-带缩略图
     * @param file
     * @param filePathType
     * @param contentType
     * @param width
     * @param height
     * @param fileType
     * @param watermarkText
     * @return
     * @throws Exception
     */
    public ImgInfo uploadMultipartFileThu(MultipartFile file, Integer filePathType, String contentType, Integer width, Integer height, String fileType, String watermarkText) throws Exception;


    /**
     * 文件上传结果
     * @param inputStream
     * @param filePathType
     * @param contentType
     * @param fileName
     * @param fileSize
     * @return
     * @throws Exception
     */
    public String uploadMultipartFile(InputStream inputStream, Integer filePathType, String contentType,  String fileName, Long fileSize) throws Exception;


    /**
     * 文件上传结果
     * @param inputStream
     * @param filePathType
     * @param contentType
     * @param fileName
     * @param fileSize
     * @param watermarkStr
     * @return
     * @throws Exception
     */
    public String uploadMultipartFile(InputStream inputStream, Integer filePathType, String contentType,  String fileName, Long fileSize, String watermarkStr) throws Exception;

    /**
     * 文件上传接口带缩略图
     * @param inputStream
     * @param filePathType
     * @param contentType
     * @param fileName
     * @param fileSize
     * @param width
     * @param height
     * @param fileType
     * @param watermarkText
     * @return
     * @throws Exception
     */
    public ImgInfo uploadMultipartFileThu(InputStream inputStream, Integer filePathType, String contentType, String fileName, Long fileSize, int width, int height, String fileType, String watermarkText) throws Exception;
    /**
     * 文件下载接口
     * @param originalName
     * @param response
     * @return
     */
    public InputStream downloadFile(String originalName, HttpServletResponse response);

    /**
     * 文件刪除
     * @param objects
     */
    public void deleteFile(List<DeleteObject> objects);
}

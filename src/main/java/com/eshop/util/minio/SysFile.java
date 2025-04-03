package com.eshop.util.minio;

import lombok.Data;

/**
 * 文件信息
 * 
 * @author rch
 */
@Data
public class SysFile {

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件地址
     */
    private String url;

    /**
     * 文件路径
     */
    private String newFilePath;


    /**
     * 缩略图文件名称
     */
    private String thumbnailName;

    /**
     * 缩略图文件地址
     */
    private String thumbnailUrl;

    /**
     * 缩略图文件路径
     */
    private String thumbnailNewFilePath;


    @Override
    public String toString() {
        return "SysFile{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", newFilePath='" + newFilePath + '\'' +
                ", thumbnailName='" + thumbnailName + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", thumbnailNewFilePath='" + thumbnailNewFilePath + '\'' +
                '}';
    }
}

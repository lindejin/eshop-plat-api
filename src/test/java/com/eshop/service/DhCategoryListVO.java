package com.eshop.service;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DhCategoryListVO {

    private DhStatusVO status;

    //参数名称	参数类型	是否必须	取值说明	参数说明
    //catePubList	CategoryPublish[]	必须		类目列表
    private List<DhCategoryListCatePubVO> catePubList;

    private String respBody;

}

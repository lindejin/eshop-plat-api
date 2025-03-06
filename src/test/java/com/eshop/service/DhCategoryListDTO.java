package com.eshop.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DhCategoryListDTO {

    //参数名称	参数类型	是否必须	取值说明	参数说明
    //parentId	String	否	传空则默认为根类目ID；若不知道父类目ID，则传空值可获取所有根类目列表，然后将根类目列表返回的类目ID值作为父类目ID查询,可以此循环查找更细粒度的类目列表；例如：014;	父类目ID
    private String parentId;
}

package com.eshop.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DhCategoryListCatePubVO {

    // leaf String 必须 1：是， 0：不是;示例值：1 该类目是否为叶子类目
    private String leaf;

    // pubName String 必须 示例值：Clothing Fabric 英文名称
    private String pubName;

    // pubNameCn String 必须 示例值：服装面料 中文名称
    private String pubNameCn;

    // catePubId String 必须 物理父级类目id + 自身id 每段为3位，共6位；示例值：014024 发布类目id
    private String catePubId;

    // pareCatePubId String 必须 物理父级类目;示例值：014 该类目的父级发布类目
    private String pareCatePubId;

    // remark String 必须 示例值：this cloth 类目备注说明
    private String remark;

}

package com.eshop.entity.base;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author ldj
 * @date 2024/3/6 15:26
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class PlatformOrder3plVO {

    /**
     * 揽收人
     */
    private Long collectionId;

    /**
     * 揽收人时间
     */
    private Date collectionTime;
}

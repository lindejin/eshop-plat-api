package com.eshop.entity.base;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Data
@Slf4j
public class PlatformSyncListResponseVO<T> {

    /**
     * 返回的json数据
     */
    private JSONObject jsonObj;

    /**
     * 第三方平台返回的列表数据
     */
    private List<T> syncList;

    /**
     * 这是为了指示数据列表是否超过一页。如果此值为 true，您可能需要继续检查下一页以检索数据。
     */
    private Boolean more;

    /**
     * 如果更多为真，则应将下一个请求中的next_cursor作为游标传递。当更多为假时，next_cursor的值将为空字符串。
     */
    private String nextCursor;

}

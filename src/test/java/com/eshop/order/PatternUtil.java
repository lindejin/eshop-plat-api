package com.eshop.order;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则相关工具类
 *
 * @author sheng
 * @date 2022-07-20 10:33
 **/
public final class PatternUtil {
    /**
     * @Param: str
     * @Author sheng
     * @Return: boolean
     * @Date: 2021-12-15 17:20
     * @Description: 判断是否是纯数字
     */
    public static boolean isNumber(String str) {
        if (str == null) {
            return false;
        }
        String p = "^\\d+$";
        Pattern pattern = Pattern.compile(p);
        return pattern.matcher(str).matches();
    }

    /**
     * 判断是否是base64图片数据
     *
     * @param str
     * @return boolean
     * @author sheng
     * @date 2023-05-18 15:55
     */
    public static boolean isBase64Img(String str) {
        if (str == null) {
            return false;
        }
        String p = "^data:image/[a-z|A-Z]{2,};base64,";
        Pattern pattern = Pattern.compile(p);
        return pattern.matcher(str).find();
    }

    /**
     * 替换花括号的内容
     *
     * @param str
     * @return boolean
     * @author sheng
     * @date 2023-05-18 15:55
     */
    public static String replaceCurlyBracketContent(String str, Map<String, Object> params) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        // 定义花括号匹配的正则表达式
        String regex = "\\{([^}]*)\\}";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);
        // 创建Matcher对象
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            // 获取匹配到的花括号中的值
            String attrName = matcher.group(1);
            Object val = params.get(attrName);
            if (Objects.nonNull(val)) {
                str = str.replace("{" + attrName + "}", String.valueOf(val));
                params.remove(attrName);
            }
        }
        return str;
    }
}

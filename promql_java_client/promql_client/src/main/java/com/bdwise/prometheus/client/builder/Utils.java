package com.bdwise.prometheus.client.builder;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description 将params设置进去
 * @Date 2020/9/28 11:04
 * @author YS
 */
public class Utils {
    private final static Pattern namedFormatPattern = Pattern.compile("#\\{(?<key>.*?)}");
    public static String namedFormat(final String format, Map<String, ? extends Object> kvs) {
        final StringBuffer buffer = new StringBuffer();
        final Matcher match = namedFormatPattern.matcher(format);
        while (match.find()) {
            final String key = match.group("key");
            final Object value = kvs.get(key);
             if (value != null) {
                 //这个方法会把匹配到的内容替换为value，
                 // 并且把从上次替换的位置到这次替换位置之间的字符串也拿到，
                 // 然后，加上这次替换后的结果一起追加到StringBuffer里
                 // （假如这次替换是第一次替换，那就是只追加替换后的字符串）
                 match.appendReplacement(buffer, value.toString());
            }
            else if (kvs.containsKey(key)) {
                match.appendReplacement(buffer, "null");
            }
            else {
                match.appendReplacement(buffer, "");
            }
        }
        //这个方法是把最后一次匹配到内容之后的字符串追加到StringBuffer中。
        match.appendTail(buffer);
        return buffer.toString();
    }    
}

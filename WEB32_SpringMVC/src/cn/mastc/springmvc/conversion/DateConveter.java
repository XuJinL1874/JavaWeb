package cn.mastc.springmvc.conversion;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName DateConveter.java
 * @Description 转换日期类型的数据
 *                  S:页面传递过来的类型
 *                  T:转换后的类型
 * @createTime 2018/11/22 16:01
 */
public class DateConveter implements Converter<String, Date> {


    @Override
    public Date convert(String source) {
        try {
            if (source != null) {
                DateFormat df = new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
                return df.parse(source);
            }
        } catch (Exception e) {
        }
        return null;
    }

}

package cn.itcast.utils;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/21
 */

import javafx.scene.input.DataFormat;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换成日期
 */
public class StringToDateConverter implements Converter<String,Date> {
    /**
     *
     * @param s 传入进来的值
     * @return
     */
    @Override
    public Date convert(String s) {
        if (s==null){
            throw new RuntimeException("传入 值为空");
        }
        SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转化错误");
        }

    }
}

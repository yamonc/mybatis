package cn.itcast.mybatis.io;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/10
 */

import java.io.InputStream;

/**
 * 使用类加载器配置文件
 */
public class Resources {
    /**
     * 根据传入的参数获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        return  Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}

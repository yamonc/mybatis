package com.itheima.factory;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/13
 */

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 一个创建BEan对象的工厂
 *
 *
 */
public class BeanFactory {
    /*
        定义一个Properties对象
     */
    private static Properties props;
    //使用静态代码块为Properties对象复制
    static {
        //实例化对象
        props=new Properties();
        //获取properties对象
        InputStream in=BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");

        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */

    public static Object getBean(String beanName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object bean;
        String beanPath=props.getProperty(beanName);
        bean=Class.forName(beanPath).newInstance();
        return bean;
    }

}

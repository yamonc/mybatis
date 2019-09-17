package com.imooc.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/9/1
 */
//说明这是springboot 的应用入口类
@SpringBootConfiguration
public class MySpringbootApplication {

    public static void main(String[] args) {
        //启动springboot应用
        SpringApplication.run(MySpringbootApplication.class,args);
    }
}

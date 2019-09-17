package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/28
 */

/**
 * 声明该类是springboot的引导类
 */
@SpringBootApplication
public class MySpringBootApplication {
    //main方法是程序的入口
    public static void main(String[] args) {
        //run方法表示要运行springboot的引导类，run参数就是springboot的引导类的字节码对象
        SpringApplication.run(MySpringBootApplication.class);
    }

}

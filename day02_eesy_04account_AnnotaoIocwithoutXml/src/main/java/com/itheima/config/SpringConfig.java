package com.itheima.config;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/18
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 该类是个配置类，作用和bean.xml一样
 *      1、spring中的新注解
 *          Configuration
 *              作用：指定当前类是一个配置类
 *              细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写
 *      2、ComponentScan：
 *              作用：用于通过注解指定spring 在创建容器时要扫描的包
 *              属性：
 *                  value：它和basePackage的作用是一样的，都是用于创建容器是要扫描ode包
 *                  我们使用此注解就==在xml中配置了：
 *                  <context:component-scan base-package="com.itheima"></context:component-scan>
 *       3、bean:
 *              作用：用于把当前方法的返回值作为bean对象存入springIoc容器内
 *              属性：
 *                  name：用于指定bean 的id；默认值：当前方法的名称
 *              细节：
 *                  当我们使用注解配置方式时：如果方法有参数，spring会去容器内查找有没有可用的bean对象
 *                  查找的方式和autowired注解 作用是一样的
 *       4. Import:
 *              作用：用于导入其他配置类
 *              属性：
 *                  value：用于 指定其他配置类的字节码。
 *                  当使用import注解后，有import注解的类就是主配置或者父配置类，导入的都是子配置类
 *       5.PropertySource:
 *              作用：用于指定properties文件的位置
 *              属性：value：指定文件名称和路径 classpath：表示类路径下
 *              如果有包：则写为config/spring...
 */
//@Configuration
@ComponentScan(basePackages = "com.itheima")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfig {


}

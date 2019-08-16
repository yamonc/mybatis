package com.itheima.servicee.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.servicee.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/13
 */
/*
账户的业务层实现类
曾经xml配置：
    <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
        scope="" init-method="" destory-method="">
        <property name="" value=""/ ref=""></property>

        </bean>
 用于创建对象的注解：
    他们的作用就和在xml编写一个<bean>实现的功能一样的
    @Component:
        作用：用于把当前类对象存入spring容器内
        属性：
            value：用于指定bean的id。当我们不写时，默认值是当前类名，且首字母小写
    @Controller：一般用在表现层
    @Service：一般用在业务层
    @Repository 一般用于持久层
    以上注解他们的作用和属性与Component是一模一样的。他们三个是spring框架为我们提供
    明确的三层使用的注解，使我们的三层对象更加清晰
用于注入数据的：
    他们的作用就和在xml配置文件中的bean标签写一个<property>标签作用是一样的
    @Autowired:
        作用：自动按照类型注入，只要容器中有唯一的bean对象类型和要注入的变量类型匹配，就可以注入成功
                如果ioc容器中没有任何bean类型和要注入变量类型匹配报错
                若谷ioc容器中有多个类型匹配时：
        出现位置：
            可以是变量上，也可以是方法上
        细节：
            在使用注解注入时，set方法就不是必须的了。

     @Qualifier：
        作用：在按照类中注入的基础之上，在按照名称注入。它在给类成员注入时不能单独使用，但是在给方法参数
        注入时可以
        属性：
            value：用于指定注入bean的id
      @Resource
         作用：
            直接按照bean的id注入可以独立使用
            属性：
                name：用于指定bean的id
      以上注解，只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
      另外，集合类型的注入，只能通过xml来实现。

      基本类型和String类型的注解方法：
            @Value:
                作用：
                    用于注入基本类型和String类型的数据
                属性：
                    value：用于指定数据的值，可以使用spring中的spEL表达式
                        sPel的写法：${表达式}
用于改变作用范围的
    他们的作用就和在bean标签中使用scope属性实现的功能是一样的
    @Scope
        作用：用于指定bean的作用范围
        属性：
            value：指定范围的取值：singleton，prototype
    <了解>
和生命周期相关的
    他们的作用就和在bean标签中使用init-method和destory-method作用一样
    PreDestory
        作用：用于指定销毁方法
    PostConstruct
        作用：用于指定初始化方法
 */
@Component( "accountService")
@Scope("prototype")
public class AccountServiceImpl implements IAccountService {
   /* @Autowired
    @Qualifier("accountDao1")*/
   @Resource(name = "accountDao2")
    private IAccountDao accountDao= null;
  //  private IAccountDao accountDao= (IAccountDao) BeanFactory.getBean("accountDao");

  @PostConstruct
    public void init() {
      System.out.println("初始化方法");

  }
  @PreDestroy
    public void destory() {
        System.out.println("销毁");

    }
    public void saveAccount() {
        accountDao.saveAccount();

    }
}

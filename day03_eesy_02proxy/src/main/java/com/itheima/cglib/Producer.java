package com.itheima.cglib;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/19
 */

import com.itheima.proxy.IProducer;

/**
 * 生成者
 */
public class Producer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售产品，并且拿到钱："+money);

    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后，并拿到钱"+money);
    }
}

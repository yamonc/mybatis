package com.imooc.entity;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/9/3
 */
public class Goods {
    private String name;
    private  double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

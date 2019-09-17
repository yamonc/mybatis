package cn.yamon.lombok;

import lombok.Setter;
import lombok.ToString;



/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/28
 */
@Setter
@ToString(exclude = "id")
public class ToStringExample {
    private static final int STATIC_VAR=10;
    private String name;
    private Shape shape=new Square(5,10);

    private String[] tags;
    private int id;

    @ToString(callSuper=true, includeFieldNames=true)
    public static class Square extends Shape {
        private final int width, height;

        public Square(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
    @ToString
    public static class Shape{
        private int color;

    }

    public static void main(String[] args){
        final ToStringExample example=new ToStringExample();
        example.setId(1);
        example.setName("abc");
        example.setTags(new String[]{"a","v","c"});

        final Shape shape=new Square(1,2);

        example.setShape(shape);
        System.out.println(example.toString());
    }
}

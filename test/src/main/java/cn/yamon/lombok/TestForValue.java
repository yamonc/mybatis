package cn.yamon.lombok;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/28
 */

import lombok.NonNull;
import lombok.Value;

import java.util.Date;

/**
 * 不可变对象valueobject @Value
 * 这个看起来很美好，就是可以帮忙生成一个不可变对象。对于所有的字段都将生成final的。
 * 但我感觉有点失控。注解的优势应该是所见即所得，可以通过字面量来传递消息。
 * 而@Value字段给字段加final会让人困惑，因为这更改了我们的定义。
 * 当我想声明一个Immutable对象的时候，我会显示的给字段加一个限定final。
 */
@Value
public class TestForValue {
    @NonNull
    private String id;
    private String name;
    private boolean active;
    private Date createTime;
}

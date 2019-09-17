package cn.yamon.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/28
 */
public class TestForLombok {
    @Setter
    @Getter
    private int age;
    @Getter
    @Setter
    private boolean active;
    @Setter
    @Getter
    private Boolean none;
    @Getter
    @Setter
    private Date date;

    @Setter(AccessLevel.PROTECTED) private String name;

    @Override
    public String toString() {
        return String.format("%s (age:%d)",name,age);
    }
    public static void main(String[] args){
        TestForLombok test=new TestForLombok();
        test.setActive(true);
        test.setAge(123);
        test.setDate(new Date());
        test.setName("aaa");
        test.setNone(false);

        Date date=test.getDate();
        Boolean none=test.getNone();
        boolean active=test.isActive();
    }
}

package cn.yamon.lombok;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/28
 */
@RequiredArgsConstructor
public class TestRequiredArgsConstructor {
    @NonNull private String filed;
    private Date date;
    private Integer integer;
    private int i;
    private boolean b;
    private Boolean aBoolean;

}

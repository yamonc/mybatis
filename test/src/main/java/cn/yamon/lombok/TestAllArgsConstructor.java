package cn.yamon.lombok;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/28
 */

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * 初试化所有字段
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class TestAllArgsConstructor<T> {

    private int x,y;
    @NonNull
    private T description;

}

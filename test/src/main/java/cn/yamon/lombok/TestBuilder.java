package cn.yamon.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.Date;
import java.util.Set;
import org.junit.Assert;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/28
 */
@Data
@Builder(toBuilder = true)
public class TestBuilder {
    @NonNull
    private String id;
    private String name;
    private boolean active;
    private Date createTime;
    @Singular
    private Set<String> occupations;

    public static void main(String[] args) {
        TestBuilder room = TestBuilder.builder().active(true)
                .name("name")
                .id("id")
                .createTime(new Date())
                .occupation("1")
                .occupation("2")
                .build();

        Assert.assertEquals(2, room.getOccupations().size());

    }
}

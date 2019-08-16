package cn.itcast.mybatis.cfg;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/10
 */

/**
 * 用于封装执行的sql语句和结果类型的全限定类名
 */
public class Mapper {
    private String queryString;//sql
    private String resultType;//实体类 全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}

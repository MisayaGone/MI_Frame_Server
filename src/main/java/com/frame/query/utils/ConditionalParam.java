package com.frame.query.utils;

/*******************************************************************************
 *
 * 条件参数   (有待完善)
 *
 * queryName       条件名称
 * queryParam      条件参数
 * queryExpression 查询表达式
 * joinExpression  连接表达式
 *
 * Created by THINK on 2016/9/30.
 */
public class ConditionalParam {

    private String queryName;

    private Object queryParam;

    private String queryExpression;

    private String joinExpression;

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public Object getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(Object queryParam) {
        this.queryParam = queryParam;
    }

    public String getQueryExpression() {
        return queryExpression;
    }

    public void setQueryExpression(String queryExpression) {
        this.queryExpression = queryExpression;
    }

    public String getJoinExpression() {
        return joinExpression;
    }

    public void setJoinExpression(String joinExpression) {
        this.joinExpression = joinExpression;
    }

    public ConditionalParam() {
    }

    public ConditionalParam(String joinExpression, String queryName, String queryExpression, Object queryParam) {
        this.queryName = queryName;
        this.queryParam = queryParam;
        this.queryExpression = queryExpression;
        this.joinExpression = joinExpression;
    }

    public ConditionalParam appendCondition(ConditionalParam conditionalParam) {


        return this;
    }
}

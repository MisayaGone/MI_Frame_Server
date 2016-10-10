package com.frame.query.utils;

/**
 * Created by THINK on 2016/10/9.
 */
public class QueryTool {

    public static <T> T getTypedDefault(T t1, T t2) {
        return t1 == null ? t2 : t1;
    }
}

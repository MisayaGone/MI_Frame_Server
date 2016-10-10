package com.frame.query.utils;

/*******************************************************************************
 *
 * 分页参数
 *
 * DEFAULT_PAGE_NUMBER  默认分页页码
 * DEFAULT_PAGE_SIZE    默认分页大小
 *
 * pageNumber       分页页码参数
 * pageSize         分页大小参数
 *
 * Created by THINK on 2016/9/30.
 */
public class PagingParam {

    public static final int DEFAULT_PAGE_NUMBER = 1;

    public static final int DEFAULT_PAGE_SIZE = 20;

    private Integer pageNumber;

    private Integer pageSize;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PagingParam() {
    }

    public PagingParam(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}

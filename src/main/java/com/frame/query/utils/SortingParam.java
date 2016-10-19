package com.frame.query.utils;

/*******************************************************************************
 *
 * 排序参数
 *
 * DEFAULT_SORT_FIELD   默认排序字段
 *
 * SORT_ORDER_ASC    升序
 * SORT_ORDER_DESC   降序
 *
 * sortField         排序字段
 * sortOrder         排序顺序
 *
 * Created by MISAYA on 2016/10/19.
 */
public class SortingParam {

    public final static String DEFAULT_SORT_FIELD = "id";      // 默认排序字段

    public final static String SORT_ORDER_ASC = "asc";       // 升序

    public final static String SORT_ORDER_DESC = "desc";     // 降序

    private String sortField;       // 排序字段

    private String sortOrder;       // 排序顺序

    public String getSortField() {

        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {

        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public SortingParam() {
        this.sortField = SortingParam.DEFAULT_SORT_FIELD;
        this.sortOrder = SortingParam.SORT_ORDER_ASC;
    }

    public SortingParam(String sortField, String sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
}

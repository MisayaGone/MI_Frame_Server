package com.frame.query.json;

import com.frame.query.utils.QueryResult;

/**
 * Created by THINK on 2016/10/18.
 */
public class JsonResult {
    // 当前页
    private Long page;
    // 总页数
    private Long total;
    // 总条数
    private Long records;

    private Object rows;

    public JsonResult(Long page, Long total, Long records, Object rows) {
        super();
        this.page = page;
        this.total = total;
        this.records = records;
        this.rows = rows;
    }

    public JsonResult(QueryResult queryResult) {
        super();
        this.page = queryResult.getCurrentPageNumber();
        this.total = queryResult.getTotalPageSize();
        this.records = queryResult.getTotalRowCount();
        this.rows = queryResult.getResultSet();
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getRecords() {
        return records;
    }

    public void setRecords(Long records) {
        this.records = records;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }
}
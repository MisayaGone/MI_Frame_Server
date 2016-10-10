package com.frame.query.utils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/*******************************************************************************
 *
 * 查询结果回执
 *
 * Created by THINK on 2016/9/30.
 */
public class QueryResult<T> {

    private List<T> resultSet;             // 当页分页数据

    private Integer currentPageSize;       // 当页分页条数

    private Integer currentPageNumber;     // 当前分页页码

    private Long totalRowCount;         // 总共多少条数据

    private Long totalPageSize;         // 总共多少页

    public List<T> getResultSet() {
        return resultSet;
    }

    public void setResultSet(List<T> resultSet) {
        this.resultSet = resultSet;
    }

    public Integer getCurrentPageSize() {
        return currentPageSize;
    }

    public void setCurrentPageSize(Integer currentPageSize) {
        this.currentPageSize = currentPageSize;
    }

    public Integer getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(Integer currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public Long getTotalPageSize() {
        return totalPageSize;
    }

    public void setTotalPageSize(Long totalPageSize) {
        this.totalPageSize = totalPageSize;
    }

    public Long getTotalRowCount() {
        return totalRowCount;
    }

    public void setTotalRowCount(Long totalRowCount) {
        this.totalRowCount = totalRowCount;
    }

    /**
     * 分页查询，返回查询结果数据封装
     *
     * @param entityManager
     * @param jpql
     * @param conditionalParams
     * @param pagingParam
     * @param entityClass
     * @param <T>
     * @return
     */
    public static <T> QueryResult<T> getQueryResult(EntityManager entityManager, String jpql, Map<String, Object> conditionalParams, PagingParam pagingParam, Class<T> entityClass) {

        // 检查分页参数
        if(pagingParam==null || pagingParam.getPageNumber() == null || pagingParam.getPageSize() == null) {
            pagingParam = new PagingParam(PagingParam.DEFAULT_PAGE_NUMBER, PagingParam.DEFAULT_PAGE_SIZE);
        }

        // 数据统计查询
        TypedQuery<Long> queryCountTyped = QueryTyped.getTypedQueryByCustomForTotalCount(entityManager, jpql, conditionalParams, Long.class);

        // 数据集合查询
        TypedQuery<T> querySetTyped = QueryTyped.getTypedQueryByCustom(entityManager, jpql, conditionalParams, pagingParam, entityClass);

        // 回执查询的数据信息
        QueryResult<T> queryResult = new QueryResult<T>();
        queryResult.setResultSet(querySetTyped.getResultList());            // 数据集合
        queryResult.setCurrentPageNumber(pagingParam.getPageNumber());      // 当前分页页码
        queryResult.setCurrentPageSize(pagingParam.getPageSize());          // 当前分页条数

        Long totalPageSize = 0L;                                            // 总页数
        Long totalDataSize = queryCountTyped.getSingleResult();
        Integer pageSize = pagingParam.getPageSize();
        if(pageSize>0 && totalDataSize>0) {
            totalPageSize = Long.valueOf(new BigDecimal(totalDataSize).divide(new BigDecimal(pagingParam.getPageSize())).setScale(0, BigDecimal.ROUND_UP) + "");
        }
        queryResult.setTotalPageSize(totalPageSize);
        queryResult.setTotalRowCount(totalDataSize);                        // 总条数
        return queryResult;
    }
}

package com.frame.query.utils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

/**
 * Created by THINK on 2016/9/30.
 */
public class QueryTyped {

    /**
     * 自定义查询语句查询
     * @param entityManager
     * @param jpql
     * @param conditionParams
     * @param pagingParam
     * @param entityClass
     * @param <T>
     * @return
     */
    public static  <T> TypedQuery<T> getTypedQueryByCustom(EntityManager entityManager, String jpql, Map<String, Object> conditionParams, PagingParam pagingParam, SortingParam sortingParam, Class<T> entityClass) {

        // 增加排序条件
        if(sortingParam!=null) {
            System.out.println(sortingParam.getSortField());
            System.out.println(sortingParam.getSortOrder());
            if(jpql.toLowerCase().indexOf("order by")<=0) {     // 判断是否存在ORDER BY 语句
                jpql += (" order by " + sortingParam.getSortField() + " " + sortingParam.getSortOrder());
            }
        }
        TypedQuery<T> typedQuery = entityManager.createQuery(jpql, entityClass);        // 创建查询对象
        typedQuery = QueryTyped.appendConditionalParam(typedQuery, conditionParams);    // 增加查询条件
//        typedQuery = QueryTyped.appendSortingParam(typedQuery, sortingParam);           // 增加排序条件
        return QueryTyped.appendPagingParam(typedQuery, pagingParam);                   // 增加分页条件
    }

    /**
     * 自定义查询条件查询 ， *** 尚不完善，只能进行简单查询操作 ***
     * @param entityManager
     * @param ConditionalParams
     * @param pagingParam
     * @param entityClass
     * @param <T>
     * @return
     */
    public static  <T> TypedQuery<T> getTypedQueryByCondition(EntityManager entityManager, List<ConditionalParam> ConditionalParams, PagingParam pagingParam, Class<T> entityClass) {

        String classSimpleName = entityClass.getSimpleName();
        StringBuffer jpqlBuffer = new StringBuffer(" select o from ").append(classSimpleName).append(" o where 1=1 ");
        // 拼接条件语句
        for(ConditionalParam param : ConditionalParams) {
            if(param.getQueryExpression()!=null && param.getQueryExpression().equals("in")) {
                jpqlBuffer.append(" " + param.getJoinExpression() +" o."+param.getQueryName() + " " + param.getQueryExpression() + " (:" + param.getQueryName() + ")");
            }else {
                jpqlBuffer.append(" " + param.getJoinExpression() +" o."+param.getQueryName() + " " + param.getQueryExpression() + " :" + param.getQueryName());
            }
        }
        TypedQuery<T> typedQuery = entityManager.createQuery(jpqlBuffer.toString(), entityClass);
        // 加入条件参数
        for(ConditionalParam param : ConditionalParams) {
            typedQuery.setParameter(param.getQueryName(), param.getQueryParam());
        }
        return QueryTyped.appendPagingParam(typedQuery, pagingParam);
    }

    // 追加查询条件
    public static <T> TypedQuery<T> appendConditionalParam(TypedQuery<T> typedQuery, Map<String, Object> conditionParams) {

        if(conditionParams!=null) {
            for (String key : conditionParams.keySet()) {
                typedQuery.setParameter(key, conditionParams.get(key));
            }
        }
        return typedQuery;
    }

//    // 追加排序条件
//    public static <T> TypedQuery<T> appendSortingParam(TypedQuery<T> typedQuery, SortingParam sortingParam) {
//
//        if(sortingParam==null) {
//            return typedQuery;
//        }
//        typedQuery.
//        return typedQuery;
//    }

    // 追加分页条件
    public static <T> TypedQuery<T> appendPagingParam(TypedQuery<T> typedQuery, PagingParam pagingParam) {

        Integer pageNumber = pagingParam.getPageNumber();
        Integer pageSize = pagingParam.getPageSize();
        if(pagingParam!=null && pageNumber!=null && pageNumber>0 && pageSize!=null && pageSize>0) {

            int minLimit = pageSize * (pageNumber - 1);
            int maxLimit = pageSize;
            typedQuery.setFirstResult(minLimit).setMaxResults(maxLimit);
        }
        return typedQuery;
    }

    public static <T> TypedQuery<T> getTypedQueryByCustomForTotalCount(EntityManager entityManager, String jpql, Map<String, Object> conditionParams, Class<T> entityClass) {

        String lowerCaseJpql = jpql.toLowerCase();
        jpql = " select count(*) " + jpql.substring(lowerCaseJpql.indexOf("from"), jpql.length());
        TypedQuery<T> typedQuery = entityManager.createQuery(jpql, entityClass);
        typedQuery = QueryTyped.appendConditionalParam(typedQuery, conditionParams);
        return typedQuery;
    }
}

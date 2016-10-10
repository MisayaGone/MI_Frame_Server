package com.frame.commons.repository.impl;

import com.frame.commons.entity.Address;
import com.frame.commons.repository.dao.IAddressDao;
import com.frame.query.utils.ConditionalParam;
import com.frame.query.utils.PagingParam;
import com.frame.query.utils.QueryResult;
import com.frame.query.utils.QueryTyped;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

/**
 * Created by THINK on 2016/9/28.
 */
public class AddressRepositoryImpl implements IAddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Address> queryPageAndSortListByCustom(String jpql, Map<String, Object> conditionalParams, PagingParam pagingParam) {

        TypedQuery<Address> addrs =  QueryTyped.getTypedQueryByCustom(entityManager, jpql, conditionalParams, pagingParam, Address.class);

        return addrs.getResultList();
    }

    public List<Address> queryPageAndSortListByCondition(List<ConditionalParam> conditionalParams, PagingParam pagingParam) {

        TypedQuery<Address> addrs = QueryTyped.getTypedQueryByCondition(entityManager, conditionalParams, pagingParam, Address.class);
        return addrs.getResultList();
    }

    public QueryResult<Address> queryQueryResult(String jpql, Map<String, Object> conditionalParams, PagingParam pagingParam) {

        QueryResult<Address> queryResult = QueryResult.getQueryResult(entityManager, jpql, conditionalParams, pagingParam, Address.class);
        return queryResult;
    }
}

package com.frame.commons.repository.dao;


import com.frame.commons.entity.Address;
import com.frame.query.utils.ConditionalParam;
import com.frame.query.utils.PagingParam;
import com.frame.query.utils.QueryResult;
import com.frame.query.utils.SortingParam;

import java.util.List;
import java.util.Map;

/**
 * Created by THINK on 2016/9/28.
 */
public interface IAddressDao {

    public List<Address> queryPageAndSortListByCustom(String jpql, Map<String, Object> conditionalParams, PagingParam pagingParam, SortingParam sortingParam);

    public List<Address> queryPageAndSortListByCondition(List<ConditionalParam> conditionalParams, PagingParam pagingParam);

    public QueryResult<Address> queryQueryResult(String jpql, Map<String, Object> conditionalParams, PagingParam pagingParam, SortingParam sortingParam);
}

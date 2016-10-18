package com.frame.security.repository.dao;

import com.frame.query.utils.PagingParam;
import com.frame.query.utils.QueryResult;
import com.frame.security.entity.SystemUser;

import java.util.Map;

/**
 * Created by THINK on 2016/10/17.
 */
public interface ISystemUserDao {

    public SystemUser getByUserAccount(String account);

    public QueryResult<SystemUser> queryQueryResult(String jpql, Map<String, Object> conditionalParams, PagingParam pagingParam);
}

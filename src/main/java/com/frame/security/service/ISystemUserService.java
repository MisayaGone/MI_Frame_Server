package com.frame.security.service;


import com.frame.query.utils.PagingParam;
import com.frame.query.utils.QueryResult;
import com.frame.security.entity.SystemUser;

import java.util.Map;

/**
 * Created by THINK on 2016/10/17.
 */
public interface ISystemUserService {

    public SystemUser getByUserAccount(String account);

    public QueryResult<SystemUser> getQueryResult(String jpql, Map<String, Object> conditionalParams, PagingParam pagingParam);
}

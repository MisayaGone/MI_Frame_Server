package com.frame.security.service.impl;

import com.frame.query.utils.PagingParam;
import com.frame.query.utils.QueryResult;
import com.frame.query.utils.SortingParam;
import com.frame.security.entity.SystemResource;
import com.frame.security.entity.SystemUser;
import com.frame.security.repository.SystemResourceRepository;
import com.frame.security.repository.SystemUserRepository;
import com.frame.security.service.ISystemResourceService;
import com.frame.security.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by THINK on 2016/10/17.
 */
@Service
public class SystemUserServiceImpl implements ISystemUserService {

    @Autowired
    private SystemUserRepository systemUserRepository;

    public SystemUser getByUserAccount(String account) {

        return systemUserRepository.getByUserAccount(account);
    }

    public QueryResult<SystemUser> getQueryResult(String jpql, Map<String, Object> conditionalParams, PagingParam pagingParam, SortingParam sortingParam) {

        return systemUserRepository.queryQueryResult(jpql, conditionalParams, pagingParam, sortingParam);
    }
}

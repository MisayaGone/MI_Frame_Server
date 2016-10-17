package com.frame.security.repository.dao;

import com.frame.security.entity.SystemUser;

/**
 * Created by THINK on 2016/10/17.
 */
public interface ISystemUserDao {

    public SystemUser getByUserAccount(String account);
}

package com.frame.security.service;


import com.frame.security.entity.SystemUser;

/**
 * Created by THINK on 2016/10/17.
 */
public interface ISystemUserService {

    public SystemUser getByUserAccount(String account);
}

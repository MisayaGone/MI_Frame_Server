package com.frame.security.service;

import com.frame.security.entity.SystemAuthority;

import java.util.List;

/**
 * Created by THINK on 2016/10/17.
 */
public interface ISystemAuthorityService {

    public List<SystemAuthority> findList();

    public List<SystemAuthority> getAuthoritiesByRoleId(Long roleId);
}

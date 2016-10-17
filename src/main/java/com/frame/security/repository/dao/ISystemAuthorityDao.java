package com.frame.security.repository.dao;

import com.frame.security.entity.SystemAuthority;

import java.util.List;

/**
 * Created by THINK on 2016/10/17.
 */
public interface ISystemAuthorityDao {

    public List<SystemAuthority> getAuthoritiesByRoleId(Long roleId);
}

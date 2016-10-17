package com.frame.security.repository.dao;

import com.frame.security.entity.SystemResource;

import java.util.List;

/**
 * Created by THINK on 2016/10/17.
 */
public interface ISystemResourceDao {

    public List<SystemResource> getResourceByAuthId(Long authId);
}

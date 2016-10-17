package com.frame.security.service;

import com.frame.security.entity.SystemResource;

import java.util.List;

/**
 * Created by THINK on 2016/10/17.
 */
public interface ISystemResourceService {

    public List<SystemResource> getResourceByAuthId(Long authId);
}

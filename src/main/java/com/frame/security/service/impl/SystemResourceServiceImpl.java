package com.frame.security.service.impl;

import com.frame.security.entity.SystemResource;
import com.frame.security.repository.SystemResourceRepository;
import com.frame.security.service.ISystemResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by THINK on 2016/10/17.
 */
@Service
public class SystemResourceServiceImpl implements ISystemResourceService {

    @Autowired
    private SystemResourceRepository systemResourceRepository;

    public List<SystemResource> getResourceByAuthId(Long authId) {

        return systemResourceRepository.getResourceByAuthId(authId);
    }
}

package com.frame.security.service.impl;

import com.frame.security.entity.SystemAuthority;
import com.frame.security.repository.SystemAuthorityRepository;
import com.frame.security.service.ISystemAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by THINK on 2016/10/17.
 */
@Service
public class SystemAuthorityServiceImpl implements ISystemAuthorityService {

    @Autowired
    private SystemAuthorityRepository systemAuthorityRepository;

    public List<SystemAuthority> findList() {
        return systemAuthorityRepository.findAll();
    }

    public List<SystemAuthority> getAuthoritiesByRoleId(Long roleId) {

        return systemAuthorityRepository.getAuthoritiesByRoleId(roleId);
    }
}

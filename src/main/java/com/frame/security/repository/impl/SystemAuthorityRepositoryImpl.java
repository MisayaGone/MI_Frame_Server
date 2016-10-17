package com.frame.security.repository.impl;

import com.frame.security.entity.SystemAuthority;
import com.frame.security.repository.dao.ISystemAuthorityDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by THINK on 2016/10/17.
 */
public class SystemAuthorityRepositoryImpl implements ISystemAuthorityDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<SystemAuthority> getAuthoritiesByRoleId(Long roleId) {

        Query query = entityManager.createQuery("select o from SystemAuthority o left join o.roleSet rs where rs.id = :roleId");
        query.setParameter("roleId", roleId);
        return query.getResultList();
    }
}

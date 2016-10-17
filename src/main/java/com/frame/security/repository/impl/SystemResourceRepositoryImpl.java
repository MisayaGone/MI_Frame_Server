package com.frame.security.repository.impl;

import com.frame.security.entity.SystemResource;
import com.frame.security.repository.dao.ISystemResourceDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by THINK on 2016/10/17.
 */
public class SystemResourceRepositoryImpl implements ISystemResourceDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<SystemResource> getResourceByAuthId(Long authId) {


        Query query = entityManager.createQuery("select o from SystemResource o left join o.authoritySet au where au.id = :authId");
        query.setParameter("authId", authId);
        return query.getResultList();
    }
}

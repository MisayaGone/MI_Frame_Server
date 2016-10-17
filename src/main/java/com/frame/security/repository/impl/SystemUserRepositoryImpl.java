package com.frame.security.repository.impl;

import com.frame.security.entity.SystemUser;
import com.frame.security.repository.dao.ISystemUserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by THINK on 2016/10/17.
 */
public class SystemUserRepositoryImpl implements ISystemUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public SystemUser getByUserAccount(String account) {

        Query query = entityManager.createQuery("select o from SystemUser o where o.deleteStatus = :deleteStatus and o.userAccount = :userAccount");
        query.setParameter("userAccount", account).setParameter("deleteStatus", false);
        List<SystemUser> users = query.getResultList();
        return  (users!=null && users.size()>0 )? users.get(0) : null;
    }
}

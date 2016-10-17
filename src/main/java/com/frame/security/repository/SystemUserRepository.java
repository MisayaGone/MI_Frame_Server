package com.frame.security.repository;

import com.frame.security.entity.SystemUser;
import com.frame.security.repository.dao.ISystemUserDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by THINK on 2016/10/17.
 */
public interface SystemUserRepository extends JpaRepository<SystemUser, Long>, ISystemUserDao {
}

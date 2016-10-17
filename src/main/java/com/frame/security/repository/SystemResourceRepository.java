package com.frame.security.repository;

import com.frame.security.entity.SystemAuthority;
import com.frame.security.entity.SystemResource;
import com.frame.security.repository.dao.ISystemResourceDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by THINK on 2016/10/17.
 */
public interface SystemResourceRepository extends JpaRepository<SystemResource, Long>, ISystemResourceDao {
}

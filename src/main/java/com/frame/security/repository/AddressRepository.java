package com.frame.security.repository;

import com.frame.commons.entity.Address;
import com.frame.commons.repository.dao.IAddressDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by THINK on 2016/9/28.
 */
public interface AddressRepository extends JpaRepository<Address, Long>, IAddressDao {
}

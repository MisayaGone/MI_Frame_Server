package com.frame.commons.service.impl;

import com.frame.commons.entity.Address;
import com.frame.commons.repository.AddressRepository;
import com.frame.commons.service.IAddressService;
import com.frame.query.utils.ConditionalParam;
import com.frame.query.utils.PagingParam;
import com.frame.query.utils.QueryResult;
import com.frame.query.utils.SortingParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by THINK on 2016/9/28.
 */
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> queryPageAndSortListByCustom(String jpql, Map<String, Object> conditionalParams, PagingParam pagingParam, SortingParam sortingParam) {

        return addressRepository.queryPageAndSortListByCustom(jpql, conditionalParams, pagingParam, sortingParam);
    }

    public List<Address> queryPageAndSortListByCondition(List<ConditionalParam> conditionalParams, PagingParam pagingParam) {

        return addressRepository.queryPageAndSortListByCondition(conditionalParams, pagingParam);
    }

    public QueryResult<Address> queryQueryResult(String jpql, Map<String, Object> conditionalParams, PagingParam pagingParam, SortingParam sortingParam) {

        return addressRepository.queryQueryResult(jpql, conditionalParams, pagingParam, sortingParam);
    }
}

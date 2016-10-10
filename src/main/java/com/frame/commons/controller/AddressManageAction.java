package com.frame.commons.controller;

import com.frame.commons.entity.Address;
import com.frame.commons.service.IAddressService;
import com.frame.query.utils.ConditionalParam;
import com.frame.query.utils.PagingParam;
import com.frame.query.utils.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * Created by THINK on 2016/9/28.
 */
@Controller
@RequestMapping("/web/address")
public class AddressManageAction {

    @Autowired
    private IAddressService addressService;

    @RequestMapping("/list")
    public String list(ModelMap mv) {

        PagingParam queryParam = new PagingParam(1, 2);
        String jpql = "select o from Address o where o.deleteStatus = :deleteStatus and o.id in (:ids) order by o.id desc";
        Map<String, Object> conditionalParams = new HashMap<String, Object>();
        conditionalParams.put("deleteStatus", false);
        List<Long> ids = new ArrayList<Long>();
        ids.add(3l);
        ids.add(5l);
        ids.add(9l);
        conditionalParams.put("ids", ids);
        List<Address> addresses = addressService.queryPageAndSortListByCustom(jpql, conditionalParams, queryParam);

        mv.put("addresses", addresses);
        return "testmvc";
    }

    @RequestMapping("/list2")
    public String list2(ModelMap mv) {

        PagingParam queryParam = new PagingParam(1, 2);
        List<ConditionalParam> conditionalParams = new ArrayList<ConditionalParam>();
        conditionalParams.add(new ConditionalParam("and", "deleteStatus", "=", false));
        Set<Long> ids = new HashSet<Long>();
        ids.add(12l);
        ids.add(15l);
        ids.add(16l);
        conditionalParams.add(new ConditionalParam("and", "id", "in", ids));
        List<Address> addresses = addressService.queryPageAndSortListByCondition(conditionalParams, queryParam);
        mv.put("addresses", addresses);
        return "testmvc";
    }

    /*****************************************************************
     * 分页条件查询案例
     * from Object o    为固定格式，否则分页出错
     *
     * @param mv
     * @return
     */
    @RequestMapping("/list3")
    public String list3(ModelMap mv) {

        PagingParam queryParam = new PagingParam(2, 2);
        String jpql = "select o from Address o where o.deleteStatus = :deleteStatus and o.id in (:ids) order by o.id desc";
        Map<String, Object> conditionalParams = new HashMap<String, Object>();
        conditionalParams.put("deleteStatus", false);
        List<Long> ids = new ArrayList<Long>();
        ids.add(3l);
        ids.add(5l);
        ids.add(9l);
        conditionalParams.put("ids", ids);
        QueryResult<Address> queryResult = addressService.queryQueryResult(jpql, conditionalParams, queryParam);

        mv.put("pageNumber", queryResult.getCurrentPageNumber());
        mv.put("pageSize", queryResult.getCurrentPageSize());
        mv.put("totalPageSize", queryResult.getTotalPageSize());
        mv.put("rows", queryResult.getResultSet());

        return "testmvc";
    }
}

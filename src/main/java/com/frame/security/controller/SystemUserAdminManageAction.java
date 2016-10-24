package com.frame.security.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.frame.commons.utils.CommUtil;
import com.frame.query.json.JsonResult;
import com.frame.query.utils.PagingParam;
import com.frame.query.utils.QueryResult;
import com.frame.query.utils.SortingParam;
import com.frame.security.entity.SystemUser;
import com.frame.security.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统用户管理
 *
 * Created by THINK on 2016/10/18.
 */
@Controller
@RequestMapping("/admin/systemUser")
public class SystemUserAdminManageAction {

    @Autowired
    private ISystemUserService systemUserService;

    /**
     * 列表显示页面
     */
    @RequestMapping("/list")
    public String list() {

        return "admin/sysUser/list";
    }

    /**
     * 列表数据
     */
    @RequestMapping("/listJson")
    public String listJson(ModelMap mv, Integer page, Integer rows, String sidx, String sord) {

        String jpql = "select a from SystemUser a where 1=1 and a.id = :id order by a.id asc";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", 1l);
        QueryResult<SystemUser> queryResult = systemUserService.getQueryResult(jpql, params, new PagingParam(page, rows), null);

        mv.put("jqcommon", JSON.toJSONStringWithDateFormat(new JsonResult(queryResult), "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat));

        return "json/jqcommon";
    }
}

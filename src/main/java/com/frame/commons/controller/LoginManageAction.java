package com.frame.commons.controller;

import com.frame.commons.utils.CommUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * login
 *
 * Created by THINK on 2016/10/17.
 */
@Controller
@RequestMapping("/admin")
public class LoginManageAction {

    @RequestMapping("/login")
    public String login(ModelMap mv, String error) {

        mv.put("error", CommUtil.null2String(CommUtil.null2Boolean(error)));
        return "admin/login/login";
    }
}

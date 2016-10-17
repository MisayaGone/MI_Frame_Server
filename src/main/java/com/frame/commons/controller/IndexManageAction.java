package com.frame.commons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index
 *
 * Created by THINK on 2016/10/17.
 */
@Controller
@RequestMapping("/admin")
public class IndexManageAction {

    @RequestMapping("/index")
    public String index() {

        return "admin/index/index";
    }

    @RequestMapping("/index_module")
    public String index_model() {

        return "admin/index/index_module";
    }

    @RequestMapping("/page404")
    public String page_404() {

        return "admin/index/404";
    }

    @RequestMapping("/page500")
    public String page500() {

        return "admin/index/500";
    }

    @RequestMapping("/page403")
    public String page403() {

        return "admin/index/403";
    }
}

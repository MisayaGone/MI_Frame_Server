package com.frame.commons.controller;

/**
 * Created by THINK on 2016/9/29.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/web")
public class TestManageAction {
    @RequestMapping("/testmvc")
    public ModelAndView testMvc(HttpServletRequest request, HttpServletResponse response) {

        response.setCharacterEncoding("utf-8");
        ModelAndView mv = new ModelAndView();
        mv.addObject("context", "成功了");;
        mv.setViewName("testmvc");
        return mv;
    }
}

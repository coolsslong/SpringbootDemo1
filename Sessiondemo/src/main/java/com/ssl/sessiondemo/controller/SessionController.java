package com.ssl.sessiondemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jylong
 * @date 2019/10/31 17:18
 */
@RestController
public class SessionController {

    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        request.getSession().setAttribute("water", request.getRequestURL());
        return request.getRequestURL().toString();
    }

    @RequestMapping("/clearSession")
    public String clearSession(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("jason");
        return "clearSession";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        return request.getSession().getAttribute("jason").toString();
    }

}

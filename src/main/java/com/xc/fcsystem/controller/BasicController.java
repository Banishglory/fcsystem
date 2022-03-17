package com.xc.fcsystem.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @作者: cayuyu
 * @描述：默认描述
 * @创建时间:
 * @修改人：
 * @修改时间：
 * @修改描述：默认描述
 */
@Controller
public class BasicController {

    @RequestMapping(value = "/login")
    public String index(HttpServletRequest request, HttpServletResponse response){



        return  "index";
    }


}

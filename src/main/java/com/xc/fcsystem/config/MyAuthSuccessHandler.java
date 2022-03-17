package com.xc.fcsystem.config;

import com.xc.fcsystem.utils.DateTimeUnit;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class MyAuthSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("进入转发ig进入时间--------------------------------------------");
        String nowTime = DateTimeUnit.formatDateD(new Date());
        System.out.println(nowTime);
        redirectStrategy.sendRedirect(request, response, "/sys/base/home");
        System.out.println("转发结束时间--------------------------------------------");
        String endTime = DateTimeUnit.formatDateD(new Date());
        System.out.println(endTime);


    }
}

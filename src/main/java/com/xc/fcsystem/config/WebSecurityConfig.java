package com.xc.fcsystem.config;

import com.xc.fcsystem.utils.DateTimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

/**
 * 安全登录拦截
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService customUserService;
    @Autowired
    private MyAuthFailureHandler myAuthFailureHandler;

    @Autowired
    private MyAuthSuccessHandler myAuthSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService).passwordEncoder(new BCryptPasswordEncoder()); //user Details Service验证

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //解决 SpringSecurityiFrame'X-Frame-Options'to'deny'
        System.out.println("进入securityConfig进入时间--------------------------------------------");
        String nowTime = DateTimeUnit.formatDateD(new Date());
        System.out.println(nowTime);
        http.headers().frameOptions().disable();
        http.csrf().disable(); //解除拦截  重要！！！！
        http.authorizeRequests()
                .antMatchers("/static/**","/third/**","/js/**").permitAll()//放开资源
                .antMatchers("/template/index.html", "/index").permitAll()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/index") //登录成功的默认跳转路径
                .successHandler(myAuthSuccessHandler)
                .failureHandler(myAuthFailureHandler)
                .failureUrl("/syslogin?error") //登录失败的跳转路径
                .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll(); //注销行为任意访问
        System.out.println("securityConfig结束时间--------------------------------------------");
        String endTime = DateTimeUnit.formatDateD(new Date());
        System.out.println(endTime);

    }




    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring() .antMatchers("/static/**");

    }
}


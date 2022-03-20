package com.xc.fcsystem;

import com.xc.fcsystem.utils.MD5Utils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.xc.fcsystem.dao.user")
@SpringBootApplication
public class FcsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FcsystemApplication.class, args);
        System.out.println("run successful");

        MD5Utils md5Utils=new MD5Utils();
        String result=md5Utils.MD5Encode("123456","utf-8",false);
        System.out.println("MD5加密："+result);
    }

}

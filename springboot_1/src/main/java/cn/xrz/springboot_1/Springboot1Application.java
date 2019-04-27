package cn.xrz.springboot_1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication //扫描范围，同级及子包 （cn.xrz.springboot_1）
@EnableAsync //开启异步调用 （扫描Async注解）
@MapperScan(basePackages = {"cn.xrz.springboot_1.mapper"}) //mapper层中可以不需要加@Mapper注解，可在启动类中添加统一添加
public class Springboot1Application {

    public static void main(String[] args) {
        //整个程序的入口，启动SpringBoot 项目创建内置Tomcat服务器，使用tomcat加载springMVC,启动注解
        SpringApplication.run(Springboot1Application.class, args);
    }

}

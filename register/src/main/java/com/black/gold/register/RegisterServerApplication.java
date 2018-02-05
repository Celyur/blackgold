package com.black.gold.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注解@EnableEurekaServer表示启动一个服务注册中心
 * 注解@SpringBootApplication表示springboot 应用标识
 *
 * @author
 */
@SpringBootApplication
@EnableEurekaServer
public class RegisterServerApplication {

    public static void main(String[] args) {
        /**启动嵌入式的tomcat,并初始化spring环境及其各spring组件*/
        SpringApplication.run(RegisterServerApplication.class, args);
    }
}

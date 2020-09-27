package com.meng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

//启动类
@SpringBootApplication
@EnableEurekaClient    //在服务启动后自动注册到eureka中！
@EnableDiscoveryClient  //服务发现 就是获取注册信息的和DiscoveryClient配合用
public class DeptProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001.class,args);
    }
}

package com.meng.springcloud.controller;

import com.meng.springcloud.pojo.Dept;
import com.meng.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/dept")
public class DeptController {
    @Resource
    private DeptService deptService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    };

    @GetMapping("/del/{id}")
    public boolean delDept(@PathVariable("id")Long id){
        return deptService.del(id);
    };

    @PostMapping("/upd")
    public boolean updDept(@RequestBody Dept dept){
        return deptService.upd(dept);
    }

    @PostMapping("/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Object get(@PathVariable("id")Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/getAll")
    public Object get(){
        return deptService.queryAll();
    }

    @Autowired
    private DiscoveryClient client;   //获取一些配置的信息，得到具体的微服务  也就是获取提供服务的信息

    //注册进来的微服务，获取一些消息
    @GetMapping("/discovery")
    public Object discovery(){
        //获取为服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:"+services);

        //得到一个具体的微服务信息，通过具体的为服务id，applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance:instances){
            System.out.println(instance.getHost()+"\t"+instance.getPort()+"\t"
            +instance.getInstanceId()+"\t"+instance.getUri());
        }
        return this.client;
    }
}

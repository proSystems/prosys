package com.meng.springcloud.controller;

import com.meng.springcloud.pojo.Dept;
import com.meng.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer/dept/")
public class DeptConsumerController {

    @Resource
    DeptClientService service;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return service.queryById(id);
    }

    @RequestMapping("/add")
    public boolean add(Dept dept){
        return service.addDept(dept);

    }

    @RequestMapping("/getAll")
    public List<Dept> list(){
        return service.queryAll();
    }
}

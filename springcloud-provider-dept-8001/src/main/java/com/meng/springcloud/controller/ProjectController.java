package com.meng.springcloud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meng.springcloud.pojo.Dto;
import com.meng.springcloud.pojo.Project;
import com.meng.springcloud.service.ProjectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pro")
public class ProjectController {
    @Resource
    ProjectService projectService;

    @RequestMapping(value = "/getAllP")
    public List<Project> findALLP(){
        return projectService.findALlProject();
    }
    @RequestMapping(value = "/getAllP1")
    public Dto findALLP1(@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "2")int size){
        PageHelper.startPage(start, size,"id asc");
        List<Project> pl = projectService.findALlProject();
        PageInfo<Project> page = new PageInfo<>(pl);
        Dto dto = new Dto();
        dto.setCode(0);
        dto.setCount((int)page.getTotal());
        dto.setData(page.getList());
        dto.setMsg("");
        return dto;
    }

    @RequestMapping(value = "/getALLPP")
    public List<Project> findALLPP(int id){
        return projectService.findALlProjectByParentId(id);
    }

    @RequestMapping(value = "/getPById")
    public Project findPById(int id){
        return projectService.findProjectById(id);
    }

}

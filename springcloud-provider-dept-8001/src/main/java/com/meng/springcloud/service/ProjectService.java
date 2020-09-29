package com.meng.springcloud.service;

import com.meng.springcloud.pojo.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectService {
    public List<Project> findALlProject();
    public List<Project> findALlProjectByParentId(int id);
    public Project findProjectById(int id);
}

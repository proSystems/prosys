package com.meng.springcloud.dao;

import com.meng.springcloud.pojo.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectDao {
    public List<Project> findALlProject();
    public List<Project> findALlProjectByParentId(@Param(value = "id")int id);
    public Project findProjectById(@Param(value = "id")int id);
}

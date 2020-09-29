package com.meng.springcloud.service;

import com.meng.springcloud.dao.ProjectDao;
import com.meng.springcloud.pojo.Project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectSeviceImpl implements ProjectService{
    @Resource
    private ProjectDao projectDao;


    @Override
    public List<Project> findALlProject() {
        return projectDao.findALlProject();
    }

    @Override
    public List<Project> findALlProjectByParentId(int id) {
        return projectDao.findALlProjectByParentId(id);
    }

    @Override
    public Project findProjectById(int id) {
        return projectDao.findProjectById(id);
    }
}

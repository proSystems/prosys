package com.meng.springcloud.service;

import com.meng.springcloud.dao.DeptDao;
import com.meng.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{
    @Resource
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }

    @Override
    public boolean del(long id) {
        return deptDao.del(id);
    }

    @Override
    public boolean upd(Dept dept) {
        return deptDao.upd(dept);
    }
}

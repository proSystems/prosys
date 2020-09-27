package com.meng.springcloud.service;

import com.meng.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();

    public boolean del(long id);

    public boolean upd(Dept dept);
}

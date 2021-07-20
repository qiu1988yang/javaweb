package com.qy.demo.demo.service;

import com.qy.demo.demo.entity.SysUser;

import java.util.List;

public interface SysUserService {

    public boolean login(SysUser user);

    public List<SysUser> getList();
}

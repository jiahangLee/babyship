package com.jiahanglee.babyship.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.dao.RoleDao;
import com.jiahanglee.babyship.entity.rbac_jpa.Role;
import com.jiahanglee.babyship.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;
    @Override
    public int addRole(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public PageInfo<Role> findAllRole(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roleDomains = roleDao.selectRole();
        PageInfo result = new PageInfo(roleDomains);
        return result;
    }

    @Override
    public int deleteRole(Integer id) {
        return roleDao.delete(id);
    }

    @Override
    public void update(Role role) {
         roleDao.update(role);
    }

    @Override
    public Role selectRole(Integer id) {
        return roleDao.selectById(id);
    }

}

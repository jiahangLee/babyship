package com.jiahanglee.babyship.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.dao.UserDao;
import com.jiahanglee.babyship.entity.rbac_jpa.User;
import com.jiahanglee.babyship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Override
    public int addUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> userDomains = userDao.selectUser();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

    @Override
    public int deleteUser(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public void update(User user) {
         userDao.update(user);
    }

    @Override
    public User selectUser(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public int selectRoleById(Integer id) {
        return userDao.selectRoleById(id);
    }

    @Override
    public User selectByUser(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public Integer selectRoleByName(String name) {
        return userDao.selectRoleByName(name);
    }
}

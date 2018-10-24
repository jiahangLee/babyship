package com.jiahanglee.babyship.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.dao.PrivilegeDao;
import com.jiahanglee.babyship.entity.rbac_jpa.Privilege;
import com.jiahanglee.babyship.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @author jiahanglee
 * @version 0.0.1
 * @date 2018/10/24 16:21
 * @description //TODO
 */
@Service(value = "PrivilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {
    @Autowired
    private PrivilegeDao PrivilegeDao;
    @Override
    public int addPrivilege(Privilege privilege) {
        return PrivilegeDao.insert(privilege);
    }

    @Override
    public PageInfo<Privilege> findAllPrivilege(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Privilege> privilegeDomains = PrivilegeDao.selectPrivilege();
        PageInfo result = new PageInfo(privilegeDomains);
        return result;
    }

    @Override
    public int deletePrivilege(Integer id) {
        return PrivilegeDao.delete(id);
    }

    @Override
    public void update(Privilege privilege) {
        PrivilegeDao.update(privilege);
    }

    @Override
    public Privilege selectPrivilege(Integer id) {
        return PrivilegeDao.selectById(id);
    }
}

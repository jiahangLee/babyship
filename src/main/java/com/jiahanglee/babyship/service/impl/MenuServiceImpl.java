package com.jiahanglee.babyship.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.dao.MenuDao;
import com.jiahanglee.babyship.entity.rbac_jpa.Menu;
import com.jiahanglee.babyship.service.MenuService;
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
@Service(value = "MenuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao MenuDao;
    @Override
    public int addMenu(Menu privilege) {
        return MenuDao.insert(privilege);
    }

    @Override
    public List<Menu> findAllMenu(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        List<Menu> privilegeDomains = MenuDao.selectMenu();
        return privilegeDomains;
    }

    @Override
    public int deleteMenu(Integer id) {
        return MenuDao.delete(id);
    }

    @Override
    public void update(Menu privilege) {
        MenuDao.update(privilege);
    }

    @Override
    public Menu selectMenu(Integer id) {
        return MenuDao.selectById(id);
    }
}

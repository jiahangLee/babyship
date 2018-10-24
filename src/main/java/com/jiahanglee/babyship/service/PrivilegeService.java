package com.jiahanglee.babyship.service;

import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.entity.rbac_jpa.Privilege;

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
 * @date 2018/10/24 16:20
 * @description //TODO
 */
public interface PrivilegeService {

    int addPrivilege(Privilege privilege);

    PageInfo<Privilege> findAllPrivilege(int pageNum, int pageSize);

    int deletePrivilege(Integer id);

    void update(Privilege privilege);

    Privilege selectPrivilege(Integer id);
}

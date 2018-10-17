package com.jiahanglee.babyship.service;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.entity.rbac_jpa.Role;


public interface RoleService {

  int addRole(Role role);

  PageInfo<Role> findAllRole(int pageNum, int pageSize);

  int deleteRole(Integer id);

  void update(Role role);

  Role selectRole(Integer id);

}

package com.jiahanglee.babyship.service;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.entity.rbac_jpa.User;


public interface UserService {

  int addUser(User user);

  PageInfo<User> findAllUser(int pageNum, int pageSize);

  int deleteUser(Integer id);

  void update(User user);
  void update2(String old_password,String password);

  User selectUser(Integer id);

  int selectRoleById(Integer id);

  User selectByUser(String user);

  Integer selectRoleByName(String name);

  String selectCname(String name);
}

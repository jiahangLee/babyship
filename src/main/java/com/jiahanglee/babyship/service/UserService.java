package com.jiahanglee.babyship.service;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.entity.Modify;
import com.jiahanglee.babyship.entity.rbac_jpa.User;


public interface UserService {

  int addUser(User user,String roleId);

  PageInfo<User> findAllUser(int pageNum, int pageSize);

  int deleteUser(Integer id);

  void update(User user,int roleId);
  void update2(Modify modify);

  User selectUser(Integer id);

  int selectRoleById(Integer id);

  User selectByUser(String user);

  Integer selectRoleByName(String name);

  String selectCname(String name);
}

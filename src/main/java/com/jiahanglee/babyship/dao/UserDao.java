package com.jiahanglee.babyship.dao;

import com.jiahanglee.babyship.entity.Teacher;
import com.jiahanglee.babyship.entity.rbac_jpa.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public interface UserDao {

    String TABLE_NAME = "user";
    String INSERT_FIELDS = "id,name";
    String SELECT_FIELDS = "ID,NAME,url";

    int insert(User user);

    int delete(int id);

    void update(User user);

    List<User> selectUser();

    User selectById(Integer id);

    int selectRoleById(Integer id);
}
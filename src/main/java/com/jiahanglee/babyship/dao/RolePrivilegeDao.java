package com.jiahanglee.babyship.dao;

import com.jiahanglee.babyship.entity.News;

import java.util.List;


public interface RolePrivilegeDao {

    String TABLE_NAME = "user";
    String INSERT_FIELDS = "id,name";
    String SELECT_FIELDS = "ID,NAME,url";

    int insert(int roleId,int privilegeId);

//    List<News> selectTeachers();

    int delete(int roleId);

    void update(int roleId,int privilegeId);

}

package com.jiahanglee.babyship.dao;

import com.jiahanglee.babyship.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RolePrivilegeDao {

    String TABLE_NAME = "user";
    String INSERT_FIELDS = "id,name";
    String SELECT_FIELDS = "ID,NAME,url";

    int insert(@Param("role_id") int roleId,@Param("privilege_id") int privilegeId);

//    List<News> selectTeachers();

    int delete(int roleId);
    int selectByRole(int roleId);

    void update(int roleId,int privilegeId);

}

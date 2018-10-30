package com.jiahanglee.babyship.dao;

import org.apache.ibatis.annotations.Param;


public interface UserRoleDao {

    String TABLE_NAME = "user";
    String INSERT_FIELDS = "id,name";
    String SELECT_FIELDS = "ID,NAME,url";

    int insert(@Param("userId") int privilegeId, @Param("roleId") int menuId);

//    List<News> selectTeachers();

    int delete(int userId);

    void update(@Param("userId")int userId,@Param("roleId") int roleId);

}

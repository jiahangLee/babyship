package com.jiahanglee.babyship.dao;

import com.jiahanglee.babyship.entity.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface PrivilegeMenuDao {

    String TABLE_NAME = "user";
    String INSERT_FIELDS = "id,name";
    String SELECT_FIELDS = "ID,NAME,url";

    int insert(@Param("privilegeId") int privilegeId, @Param("menuId") int menuId);

//    List<News> selectTeachers();

    int delete(int privilegeId);

    void update(int privilegeId,int menuId);

}

package com.jiahanglee.babyship.dao;

import com.jiahanglee.babyship.entity.News;

import java.util.List;


public interface NewsDao {

    String TABLE_NAME = "user";
    String INSERT_FIELDS = "id,name";
    String SELECT_FIELDS = "ID,NAME,url";

    int insert(News news);

    List<News> selectTeachers();
    News selectTeachersById(int id);

    int delete(int id);

    void update(News news);

}

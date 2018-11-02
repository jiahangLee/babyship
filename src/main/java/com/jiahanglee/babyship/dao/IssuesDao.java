package com.jiahanglee.babyship.dao;

import com.jiahanglee.babyship.entity.Issues;

import java.util.List;


public interface IssuesDao {

    String TABLE_NAME = "user";
    String INSERT_FIELDS = "id,name";
    String SELECT_FIELDS = "ID,NAME,url";

    int insert(Issues issues);

    List<Issues> selectTeachers();

    int delete(int id);

    void update(Issues issues);

}

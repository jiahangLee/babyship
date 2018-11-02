package com.jiahanglee.babyship.service;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.entity.Issues;


public interface IssuesService {

  int addTeacher(Issues issues);

  PageInfo<Issues> findAllTeacher(int pageNum, int pageSize);

  int deleteTeacher(Integer id);

  void update(Issues issues);

}

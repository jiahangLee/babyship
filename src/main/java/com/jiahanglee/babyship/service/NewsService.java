package com.jiahanglee.babyship.service;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.entity.News;


public interface NewsService {

  int addTeacher(News teacher);

  PageInfo<News> findAllTeacher(int pageNum, int pageSize);

  int deleteTeacher(Integer id);

  void update(News teacher);

}

package com.jiahanglee.babyship.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.dao.NewsDao;
import com.jiahanglee.babyship.entity.News;
import com.jiahanglee.babyship.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "newsService")
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsDao teacherDao;
    @Override
    public int addTeacher(News teacher) {
        return teacherDao.insert(teacher);
    }

    @Override
    public PageInfo<News> findAllTeacher(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<News> userDomains = teacherDao.selectTeachers();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

    @Override
    public News selectTeachersById(int id) {
        return teacherDao.selectTeachersById(id);
    }

    @Override
    public int deleteTeacher(Integer id) {
        return teacherDao.delete(id);
    }

    @Override
    public void update(News teacher) {
         teacherDao.update(teacher);
    }
}

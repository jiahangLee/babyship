package com.jiahanglee.babyship.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.dao.TeacherDao;
import com.jiahanglee.babyship.entity.Teacher;
import com.jiahanglee.babyship.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "teacherService")
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherDao teacherDao;
    @Override
    public int addTeacher(Teacher teacher) {
        return teacherDao.insert(teacher);
    }

    @Override
    public PageInfo<Teacher> findAllTeacher(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> userDomains = teacherDao.selectTeachers();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

    @Override
    public Teacher selectTeacherById(int id) {
        return teacherDao.selectTeachersById(id);
    }

    @Override
    public int deleteTeacher(Integer id) {
        return teacherDao.delete(id);
    }

    @Override
    public void update(Teacher teacher) {
         teacherDao.update(teacher);
    }
}

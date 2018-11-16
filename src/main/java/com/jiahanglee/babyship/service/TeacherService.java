package com.jiahanglee.babyship.service;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.entity.Teacher;


    public interface TeacherService {

      int addTeacher(Teacher teacher);

      PageInfo<Teacher> findAllTeacher(int pageNum,int pageSize);

      Teacher selectTeacherById(int id);

      int deleteTeacher(Integer id);

      void update(Teacher teacher);

}

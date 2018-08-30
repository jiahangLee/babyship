package com.jiahanglee.babyship.service;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.entity.Teacher;

import java.util.List;

    public interface TeacherService {

      int addTeacher(Teacher teacher);

      PageInfo<Teacher> findAllTeacher(int pageNum,int pageSize);

}

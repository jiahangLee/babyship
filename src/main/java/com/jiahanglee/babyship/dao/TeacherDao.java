package com.jiahanglee.babyship.dao;

import com.jiahanglee.babyship.entity.Teacher;
import java.util.List;


    public interface TeacherDao {

        String TABLE_NAME = "user";
        String INSERT_FIELDS = "id,name";
        String SELECT_FIELDS = "ID,NAME,url";

        int insert(Teacher teacher);

        List<Teacher> selectTeachers();

        int delete(int id);

        void update(Teacher teacher);

    }

package com.jiahanglee.babyship.dao;

import com.jiahanglee.babyship.entity.Teacher;

import java.util.List;


    public interface TeacherDao {
        /**
         * 列出区域列表
         *
         * @return areaList
         */
        List<Teacher> queryArea();

        /**
         * 根据Id列出具体区域
         *
         * @return area
         */
        Teacher queryAreaById(int areaId);

        /**
         * 插入区域信息
         *
         * @param area
         * @return
         */
        int insertArea(Teacher area);

        /**
         * 更新区域信息
         *
         * @param area
         * @return
         */
        int updateArea(Teacher area);

        /**
         * 删除区域信息
         *
         * @param areaId
         * @return
         */
        int deleteArea(int areaId);
    }

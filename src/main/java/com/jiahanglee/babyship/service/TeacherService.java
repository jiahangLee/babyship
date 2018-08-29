package com.jiahanglee.babyship.service;
import com.jiahanglee.babyship.entity.Teacher;

import java.util.List;

    public interface TeacherService {

        /**
         * 获取区域列表
         *
         * @return
         */
        List<Teacher> getAreaList();

        /**
         * 通过区域Id获取区域信息
         *
         * @param areaId
         * @return
         */
        Teacher getAreaById(int areaId);

        /**
         * 增加区域信息
         *
         * @param area
         * @return
         */
        boolean addArea(Teacher area);

        /**
         * 修改区域信息
         *
         * @param area
         * @return
         */
        boolean modifyArea(Teacher area);

        /**
         * 删除区域信息
         *
         * @param areaId
         * @return
         */
        boolean deleteArea(int areaId);



}

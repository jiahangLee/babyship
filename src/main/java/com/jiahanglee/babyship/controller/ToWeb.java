package com.jiahanglee.babyship.controller;

import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.entity.News;
import com.jiahanglee.babyship.entity.Teacher;
import com.jiahanglee.babyship.service.NewsService;
import com.jiahanglee.babyship.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @author jiahanglee
 * @version 0.0.1
 * @date 2018/9/10 16:16
 * @description //TODO
 */
@CrossOrigin
@RestController
public class ToWeb {

    @Autowired
    private NewsService newsService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping(value = "/getNews")
    public PageInfo<News> getNews(
        @RequestParam(name = "pageNum", required = false, defaultValue = "1")
        int pageNum,
        @RequestParam(name = "pageSize", required = false, defaultValue = "10")
        int pageSize) {
            return newsService.findAllTeacher(pageNum, pageSize);
    }

    @GetMapping(value = "/getTeachers")
    public PageInfo<Teacher> getTeachers(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize) {
        return teacherService.findAllTeacher(pageNum, pageSize);
    }


}

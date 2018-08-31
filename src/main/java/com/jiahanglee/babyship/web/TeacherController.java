package com.jiahanglee.babyship.web;

import com.jiahanglee.babyship.entity.Teacher;
import com.jiahanglee.babyship.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add")
    public int addUser(Teacher user) {
        return teacherService.addTeacher(user);
    }

    @GetMapping(value = "/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize) {
        return teacherService.findAllTeacher(pageNum, pageSize);
    }
}

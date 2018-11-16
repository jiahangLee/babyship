package com.jiahanglee.babyship.controller;

import com.jiahanglee.babyship.entity.Teacher;
import com.jiahanglee.babyship.service.TeacherService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


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
    @GetMapping(value = "/selectTeacherById")
    public Object selectTeacherById(
            @RequestParam(name = "id", required = false, defaultValue = "1")
                    int id) {
        return teacherService.selectTeacherById(id);
    }

    @GetMapping(value = "/delete")
    public int deleteTeacher(@RequestParam(name = "id",required = false) Integer id){
          return teacherService.deleteTeacher(id);
    }

    @PostMapping(value = "/update")
    public void update(Teacher teacher){
         teacherService.update(teacher);
    }

    @RequestMapping(value = "/download")
    public void downloadLocal(HttpServletResponse response,String url) throws FileNotFoundException {
        FileInputStream fis = null;
        //http://localhost:8002/babyship/download?url=C:/Users/Administrator/Desktop/upload/d6d35599-6c90-44e1-b005-4347e5f6d251.jpg
        File file = new File(url);
        //File file = new File("home/images/test.png"); 服务器目录和本地图片的区别是图片路径
        fis = new FileInputStream(file);
        response.setContentType("image/jpg");
        //设置返回的文件类型
        response.setHeader("Access-Control-Allow-Origin", "*");
        //设置该图片允许跨域访问
        try {
            IOUtils.copy(fis, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

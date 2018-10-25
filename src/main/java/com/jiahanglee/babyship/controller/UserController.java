package com.jiahanglee.babyship.controller;

import com.jiahanglee.babyship.entity.Modify;
import com.jiahanglee.babyship.entity.rbac_jpa.User;
import com.jiahanglee.babyship.service.UserService;
import com.jiahanglee.babyship.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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
 * @date 2018/9/18 11:02
 * @description //TODO
 */
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser")
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @GetMapping(value = "/deleteUser")
    public int deleteUser(@RequestParam(name = "id", required = false) Integer id) {
        return userService.deleteUser(id);
    }

    @PostMapping(value = "/updateUser")
    public void updateUser(User user)
    {
        System.out.println("修改密码"+user.toString());
        userService.update(user);
    }
    @PostMapping(value = "/updateUser2")
    public void updateUser2(Modify modify) {
        System.out.println("修改密码"+modify.toString());
        userService.update2(modify);
    }

    @GetMapping(value = "/allUser")
    public Object allUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize
    ) {
        return userService.findAllUser(pageNum, pageSize);
    }

//    @GetMapping(value = "/login")
//    public boolean login(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
//            @RequestParam(name = "id", required = false) Integer id,
//            @RequestParam(name = "password", required = false) String password
//    ) {
//        if (userService.selectUser(id) == null )
//        {return false;}
//        else if(userService.selectUser(id).getPassword().equals(password)) {
//            Cookie cookie = new Cookie("username", "username-----"+id);
//            cookie.setPath(httpServletRequest.getContextPath());
//            cookie.setMaxAge(80000);
//            httpServletResponse.addCookie(cookie);
//            return userService.selectUser(id).getPassword().equals(password);
//        }else {return false;}
//    }
    @GetMapping(value = "/selectRoleById")
    public int selectRoleById(@RequestParam(value = "id",required = false)Integer id){
        return userService.selectRoleById(id);
    }

    @GetMapping(value = "/selectByName")
    public Object selectByName1(@RequestParam(value = "name",required = false)String name){
        return userService.selectByUser(name);
    }

    @GetMapping(value = "/selectRoleByName")
    public Integer selectRoleByName(@RequestParam(value = "name",required = false)String name){
        return userService.selectRoleByName(name);
    }

    @GetMapping(value = "/selectUser")
    public Object selectByName(@RequestParam(value = "id",required = false)Integer id){
        return userService.selectUser(id);
    }

    @GetMapping(value = "selectCname")
    public String selectCname(@RequestParam(value = "name",required = false)String name){
        return userService.selectCname(name);
    }
}

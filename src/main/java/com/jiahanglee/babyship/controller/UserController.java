package com.jiahanglee.babyship.controller;

import com.jiahanglee.babyship.entity.rbac_jpa.User;
import com.jiahanglee.babyship.service.UserService;
import com.jiahanglee.babyship.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public int addUser(User user){
        return userService.addUser(user);
    }
    @GetMapping(value = "/deleteUser")
    public int deleteUser(@RequestParam(name = "id",required = false)Integer id){
        return userService.deleteUser(id);
    }
    @PostMapping(value = "/updateUser")
    public void updateUser(User user){
         userService.update(user);
    }
    @GetMapping(value = "/allUser")
    public Object allUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize
    ) {
        return userService.findAllUser(pageNum,pageSize);
    }
    @GetMapping(value = "/login")
    public boolean login(
            @RequestParam(name = "id",required = false)Integer id,
            @RequestParam(name = "password",required = false)String password
    ){
        return userService.selectUser(id).getPassword().equals(password);
    }
}

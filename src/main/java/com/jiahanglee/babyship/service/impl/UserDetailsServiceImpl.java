package com.jiahanglee.babyship.service.impl;

import com.jiahanglee.babyship.dao.UserDao;
import com.jiahanglee.babyship.entity.rbac_jpa.JwtUser;
import com.jiahanglee.babyship.entity.rbac_jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author:
 * @Description:自定义登录验证规则
 * @Date: 2018/8/9 16:00
 * @Modified By:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 密码加密方式
     * @return
     */
    private BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /**
     * 根据传进来的参数来确认凭证
     * 可以自定义 例如：用户的手机号->openid 可以对应于（name,password）
     * @param phone
     * @return
     * @throws UsernameNotFoundException
     */
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {

        /**
         * 根据参数获取凭证 可以对接数据库 redis等
         * 例如 当phone="15512343256"时，openId为"1002222224998989"
         * 验证时需要有密码规则即需要用户注册时将密码加密插入数据库
         * 举例：
         */
//        String realPhone = "15512343256";
//        String openId = "";
//        if(realPhone.equals(phone)){
//            openId = bCryptPasswordEncoder().encode("1002222224998989");
//        }
        User user = userDao.selectByName(phone);
        JwtUser jwtUser =  new JwtUser(user.getName(),bCryptPasswordEncoder().encode(user.getPassword()));
        System.out.println(jwtUser);
        return jwtUser;
    }
}

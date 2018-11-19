package com.jiahanglee.babyship.authorize.impl;

import com.jiahanglee.babyship.authorize.RbacService;
import com.jiahanglee.babyship.dao.MenuDao;
import com.jiahanglee.babyship.dao.UserDao;
import com.jiahanglee.babyship.entity.rbac_jpa.Menu;
import com.jiahanglee.babyship.entity.rbac_jpa.User;
import com.jiahanglee.babyship.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component("rbacService")
public class RbacServiceImpl implements RbacService {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private UserDao userDao;

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        System.out.println(
                "匹配url资源成功"
        );
        List<String> usernames = userDao.selectUserName();
        System.out.println(
                usernames
        );
        Object principal = authentication.getPrincipal();
        System.out.println(
                "匹配url资源成功---"+principal.toString()+principal.getClass().getTypeName()
        );
        Boolean hasPermission = false;
        if (MyUtil.MyListContent(usernames,principal.toString())) {
            String username = principal.toString();
            User user = userDao.selectByName(username);
            System.out.println(
                    "user"+user
            );
            int userId = user.getId();
            System.out.println(
                    "userId"+userId
            );
            // 根据用户获取应有权限
            Set<String> urls = new HashSet<>();
            // 根据userId获取roleId
            int roleId = userDao.selectRoleById(userId);
            System.out.println(
                    "roleId"+roleId
            );
            //获取该role下所有menus
            List<Menu> aboutMenus = menuDao.selectByRole(roleId);

            for (Menu menu : aboutMenus) {
                urls.add(menu.getUrl());
            }
            System.out.println(
                    aboutMenus+"::::"+urls
            );
            for (String url : urls) {
                //这里的toString（）不能省略，因为url中的‘+’
                if (antPathMatcher.match(url,request.getRequestURI().toString())) {
                    System.out.println(
                            "匹配url资源成功"
                    );
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }

}

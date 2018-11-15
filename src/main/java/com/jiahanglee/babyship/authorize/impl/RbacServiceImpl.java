package com.jiahanglee.babyship.authorize.impl;

import com.jiahanglee.babyship.authorize.RbacService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Component("rbacService")
public class RbacServiceImpl implements RbacService {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        Boolean hasPermission = false;
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            //根据用户获取应有权限
            Set<String> urls = new HashSet<>();

//            for (String url : urls) {
//                if (antPathMatcher.match(url,request.getRequestURI())) {
//                    hasPermission = true;
//                    break;
//                }
//            }
        }
        return hasPermission;
    }
}

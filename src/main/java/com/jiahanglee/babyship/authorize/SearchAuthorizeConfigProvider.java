package com.jiahanglee.babyship.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
@Order(Integer.MAX_VALUE)
public class SearchAuthorizeConfigProvider implements AuthorizeConfigProvider{

    @Autowired
    private HttpServletRequest request;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.anyRequest().access("@rbacService.hasPermission(request,authentication)");
    }
}

package com.jiahanglee.babyship.authorize.impl;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MIN_VALUE)
public class AuthorizeConfigProviderImpl implements com.jiahanglee.babyship.authorize.AuthorizeConfigProvider {
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers("/hello2").authenticated()
                .antMatchers("/allRoles").permitAll()
                // 需要角色为ADMIN才能删除该资源
                .antMatchers("/hello").permitAll()
                .antMatchers("/allNews").permitAll()
                .antMatchers("/issues").permitAll()
                .antMatchers("/all").permitAll()
                .antMatchers("/download").permitAll()
                .antMatchers("/allIssues").permitAll()
                .antMatchers("/designRole").permitAll()
                .antMatchers("/selectMenusByRole").permitAll();

                // 其他都放行了


    }
}

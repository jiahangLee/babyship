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
                .antMatchers("/hello").permitAll()
                //role
                .antMatchers("/allRoles").permitAll()
//                .antMatchers("/designRole").permitAll()
                .antMatchers("/selectMenusByRole").permitAll()
                //news
                .antMatchers("/*News").permitAll()
                //issues
                .antMatchers("/*issues").permitAll()
                .antMatchers("/*Issues").permitAll()
                .antMatchers("/allIssues").permitAll()
                //teachers
                .antMatchers("/all").permitAll()
                .antMatchers("/add").permitAll()
                .antMatchers("/update").permitAll()
                .antMatchers("/delete").permitAll()

                .antMatchers("/download").permitAll();
    }
}

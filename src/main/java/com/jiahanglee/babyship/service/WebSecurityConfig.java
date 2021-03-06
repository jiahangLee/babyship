package com.jiahanglee.babyship.service;


import com.jiahanglee.babyship.authorize.AuthorizeConfigManager;
import com.jiahanglee.babyship.filter.JWTAuthenticationFilter;
import com.jiahanglee.babyship.filter.JWTLoginFilter;
import com.jiahanglee.babyship.util.JWTAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author:aha
 * @Description: SpringSecurity的配置
 * 通过SpringSecurity的配置，将JWTLoginFilter，JWTAuthenticationFilter组合在一起
 * @Date: 2018/8/9 16:43
 * @Modified By:
 */
@EnableWebSecurity
// 至于为什么要配置这个，嘿嘿，卖个关子
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
//                //跳转登录页面
//                .formLogin()
//                //自定义登录页面
//                //.loginPage("login.html")
//                .and()
//                .logout()
//                .and()
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .exceptionHandling().authenticationEntryPoint(new JWTAuthenticationEntryPoint());

        authorizeConfigManager.config(http.authorizeRequests());
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

}

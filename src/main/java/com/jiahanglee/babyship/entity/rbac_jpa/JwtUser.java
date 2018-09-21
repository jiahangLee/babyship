package com.jiahanglee.babyship.entity.rbac_jpa;


import com.jiahanglee.babyship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by echisan on 2018/6/23
 */
public class JwtUser implements UserDetails {

    private Integer id;
    private String name;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    @Autowired
    private UserService userService;
    public JwtUser(String phone,String openId) {
        name = phone;
        password = openId;
        authorities = Collections.singleton(new SimpleGrantedAuthority("1"));
    }

        @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }

}

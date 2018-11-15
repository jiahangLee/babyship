package com.jiahanglee.babyship.authorize.impl;

import com.jiahanglee.babyship.authorize.AuthorizeConfigManager;
import com.jiahanglee.babyship.authorize.AuthorizeConfigProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorizeConfigManagerImpl implements AuthorizeConfigManager {

    @Autowired
    private List<AuthorizeConfigProvider> authorizeConfigProviders;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

        for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
            authorizeConfigProvider.config(config);
        }
//        config.anyRequest().permitAll();

    }
}

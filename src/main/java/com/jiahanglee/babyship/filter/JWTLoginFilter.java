package com.jiahanglee.babyship.filter;


import com.jiahanglee.babyship.entity.rbac_jpa.JwtUser;
import com.jiahanglee.babyship.util.JwtTokenUtils;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 * attemptAuthentication ：接收并解析用户凭证。
 * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 *
 * @author aha on 2018/8/6 17:47
 */
@CrossOrigin
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {


    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 接收并解析用户凭证
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        //从输入流中获取登录信息
        try {
            System.out.println("尝试登录");

            //手机号
            String phone = request.getParameter("username");
            //在此处可以设置跨域成功
            response.setHeader("Access-Control-Allow-Origin", "*");
            //用户openId
            String openId = request.getParameter("password");
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            phone, openId, new ArrayList<>()
                    )
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        JwtUser principal001 = ((JwtUser) authResult.getPrincipal());
        String principal = principal001.getUsername();
        String role = "";
        String Cname = principal001.getCn_name();
        String username = principal001.getUsername();
        // 因为在JwtUser中存了权限信息，可以直接获取，由于只有一个角色就这么干了
        Collection<? extends GrantedAuthority> authorities = principal001.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();
        }
        //这里拿到role
        String token = JwtTokenUtils.createToken(principal, role, false);
        //cookie中不能有空格
        Cookie cookie = new Cookie(JwtTokenUtils.TOKEN_HEADER,token);
        cookie.setMaxAge(10);
        response.addCookie(cookie);
        System.out.println("【登录成功，token->】" + JwtTokenUtils.TOKEN_PREFIX + token);
        response.addHeader(JwtTokenUtils.TOKEN_HEADER, JwtTokenUtils.TOKEN_PREFIX + token);
        response.setHeader("token", JwtTokenUtils.TOKEN_PREFIX + token);
        response.setStatus(200);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
//      response.setHeader("Access-Control-Expose-Headers","Origin,X-Pagination-Current-Page,Content-Type,Accept" );
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Expose-Headers", "*");
        //设置前端接收cookie
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        PrintWriter writer = response.getWriter();
        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
        map.put("Cname", Cname);
        map.put("username",username);
//        writer.write(map.toString());
        writer.write(String.valueOf(new JSONObject(map)));
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getPrincipal();
    }

    /**
     * 这是验证失败时候调用的方法
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        //下面的跨域设置不知道为什么不管用，前端照样会报错
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
        PrintWriter writer = response.getWriter();
        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
//      writer.write(map.toString());
        writer.write(String.valueOf(new JSONObject(map)));

    }
}

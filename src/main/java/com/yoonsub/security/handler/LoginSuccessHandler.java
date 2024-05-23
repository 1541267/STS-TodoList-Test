package com.yoonsub.security.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;


@Log4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res,
            Authentication auth) throws IOException, ServletException {
     
        log.info("Login Success.....");
        
        
        List<String> roleNames = new ArrayList<>();

        
        auth.getAuthorities().forEach(authority -> {

            roleNames.add(authority.getAuthority());

        });
        System.out.println("Handler roleNames: " + roleNames);
        res.setStatus(HttpServletResponse.SC_OK);

        log.warn("ROLE NAMES: " + roleNames);
        String username = auth.getName();
        
        if (roleNames.contains("ROLE_ADMIN")) {
            res.sendRedirect("/todo/memberList");
            return;
        }
        
        if (roleNames.contains("ROLE_MEMBER")) {
            res.sendRedirect("/todo/list"); // username 파라미터 추가
            return;
        }
        
        if (roleNames.contains("ROLE_USER")) {
            res.sendRedirect("/todo/list"); // username 파라미터 추가
            return;
        }
      
//        res.sendRedirect("/?username=" + username); // username 파라미터 추가
    }

}

package com.yoonsub.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;

import lombok.extern.log4j.Log4j;

@Log4j
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.error("Access Denied Handler");
        log.error("Redirect....");
        
        res.sendRedirect("../todo/errorPage");

    }

}

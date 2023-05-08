package com.masai.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class JwtTokenGeneratorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        SecurityContext ctx= SecurityContextHolder.getContext();
        Authentication authentication=ctx.getAuthentication();
        if(authentication!=null){
            Date iatDate=new Date();
            Date expDate=new Date();
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(expDate);
            calendar.add(calendar.HOUR, 4);


        }
    }
}

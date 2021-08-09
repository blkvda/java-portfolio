package com.home.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoggerIpFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Hello from LoggerIpFilter before FilterChain.doFilter()");
        System.out.println("Address of client: " + req.getLocalAddr());
        req.setAttribute("filterParam", "test");
        chain.doFilter(req, res);
        System.out.println("Hello from LoggerIpFilter after FilterChain.doFilter()");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Filter has been initiated");
    }
}

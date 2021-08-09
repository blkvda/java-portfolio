package com.home.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrintInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("1st: Print info from PrintInfoServlet");
        resp.getWriter().println(String.format("2nd: context param = %s", getServletContext().getInitParameter("contextParam")));
        resp.getWriter().println(String.format("3rd: servlet param = %s", getInitParameter("servletParam")));
    }
}

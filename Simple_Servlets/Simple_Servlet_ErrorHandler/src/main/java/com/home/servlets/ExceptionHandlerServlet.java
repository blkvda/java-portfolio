package com.home.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String title = "Exception handler servlet";
        String docType = "<!DOCTYPE html>";
        resp.setContentType("text/html");

        Integer code = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String message = (String) req.getAttribute("javax.servlet.error.message");
        Object exceptionType = req.getAttribute("javax.servlet.error.exception_type");
        String requestURI = (String) req.getAttribute("javax.servlet.error.request_uri");
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");
        Exception exception = (Exception) req.getAttribute("javax.servlet.error.exception");

        writer.println(docType + "<html>" +
                "<head>" +
                "<title>" + title + "</title>" +
                "</head>" +
                "<h2>Status code:</h2> " + code + "</br>" +
                "<h2>Message:</h2> " + message + "</br>" +
                "<h2>Exception type:</h2> " + exceptionType + "</br>" +
                "<h2>Requested URI:</h2> " + requestURI + "</br>" +
                "<h2>Servlet name:</h2> " + servletName + "</br>" +
                "<h2>Exception:</h2> " + exception +
                "<body>");
    }
}

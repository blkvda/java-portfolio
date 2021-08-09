package com.home.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServiceFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        String title = "Test service html form";
        String docType = "<!DOCTYPE html>";

        writer.println(docType + "<html>" +
                "<head><title>" + title + "</title></head>\n" +
                "<body><h2>Firstname: </h2>" + req.getParameter("firstname") +
                "<h2>Age: </h2>" + req.getParameter("age")
                + "</body>" +
                "</html>");
    }
}

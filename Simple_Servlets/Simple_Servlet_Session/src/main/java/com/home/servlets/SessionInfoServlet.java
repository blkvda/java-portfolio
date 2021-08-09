package com.home.servlets;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class SessionInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String id = httpSession.getId();
        LocalDateTime creationLocalDateTime = Instant.ofEpochSecond(httpSession.getCreationTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime LastAccessedLocalDateTime = Instant.ofEpochSecond(httpSession.getLastAccessedTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        Boolean isNewSession = httpSession.isNew();

        if(!isNewSession){
            httpSession.setAttribute("sessionAtt", "test session scope attribute");
        }

        PrintWriter writer = resp.getWriter();
        String title = "Test HttpSession";
        String docType = "<!DOCTYPE html>";
        resp.setContentType("text/html");
        writer.println(docType + "<body>" + "<head><title>" + title + "</title></head>" + "<h2>HttpSession info</h2>" +
                "<h3>Id: </h3> " + id + "</br>" +
                "<h3>Creation LocalDateTime: </h3> " + creationLocalDateTime + "</br>" +
                "<h3>Last accessed LocalDateTime: </h3> " + LastAccessedLocalDateTime + "</br>" +
                "<h3>New session: </h3> " + isNewSession + "</br>" +
                "<h3>Session attribute: </h3> " + httpSession.getAttribute("sessionAtt") + "</br>" +
                "</body></html>");
    }
}

package com.home.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("method doGet() called");

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String title = "HTTP Request Example";

        String contentType = "<!DOCTYPE html>\n";

        writer.println(contentType + "<html>\n" +
                "<head><title>" + title + "</title></head>" +
                "<body>" +
                "<h1>HTTP Servlet Request Example </h1>"
        );

        Enumeration headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String parameterName = (String) headers.nextElement();
            String parameterValue = req.getHeader(parameterName);
            writer.println("<h3>" + parameterName + ": " + parameterValue + "</h3>" + "\n");
        }

        Enumeration paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String parameterName = (String) paramNames.nextElement();
            String parameterValue = req.getParameter(parameterName);
            writer.println("<h3>" + parameterName + ": " + parameterValue + "</h3>" + "\n");
        }

        writer.println("</body>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("method init() run");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("method destroy() run");
    }
}

package com.home.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class CookiesTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie remoteAddressCookie = new Cookie("remoteAddress", req.getRemoteAddr());
        /*Browsers will not send cookie attributes back to the server. They will only send the cookie’s name-value pair.*/
        remoteAddressCookie.setMaxAge(20);
        remoteAddressCookie.setVersion(1);
        remoteAddressCookie.setDomain("localhost");
        remoteAddressCookie.setSecure(false);
        remoteAddressCookie.setComment("With some cookie params");

        Cookie requestLocalDateTimeCookie = new Cookie("requestLocalDateTime", LocalDateTime.now().toString());
        resp.addCookie(remoteAddressCookie);
        resp.addCookie(requestLocalDateTimeCookie);

        PrintWriter writer = resp.getWriter();
        String title = "Cookies test";
        String docType = "<!DOCTYPE html>";
        resp.setContentType("text/html");

        Cookie[] cookies = req.getCookies();
        writer.println(docType + "<body>" + "<head><title>" + title + "</title></head>" + "<h2>Test Cookies:</h2>");
        writer.println("<h5>Browsers will not send cookie attributes back to the server. They will only send the cookie's name-value pair.</h5>");
        if(cookies != null){
            for(int i = 0; i < cookies.length; i++){
                writer.println("<h3>" + cookies[i].getName() + ":</h3>value: " + cookies[i].getValue()+ "</br>");
                writer.println("Comment: " + cookies[i].getComment() +"</br>Domain: " + cookies[i].getDomain() + "</br>");
                writer.println("Path: " + cookies[i].getPath() + "</br>Max age: " + cookies[i].getMaxAge() + "</br>");
                writer.println("Secure: " + cookies[i].getSecure() + "</br>Version: " + cookies[i].getVersion() + "</br>");
            }
        }
        writer.println("</body></html>");
    }
}

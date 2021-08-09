package com.home.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class PrintAttrServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Enumeration<String> attributeNamesNames = req.getAttributeNames();
        if(attributeNamesNames != null){
            while (attributeNamesNames.hasMoreElements()){
                String attributeName = attributeNamesNames.nextElement();
                writer.println(String.format("Attr name: %s; attr value: %s", attributeName, req.getAttribute(attributeName)));
            }
        }
    }
}

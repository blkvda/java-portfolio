package com.home.servlets;

import com.home.Storage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.invalidate();

        Integer countOfSessions = Storage.getCountOfSessions().get();
        System.out.println(countOfSessions);
        req.setAttribute("countOfSessions", countOfSessions);

        req.getRequestDispatcher("MyPage.jsp").forward(req, resp);
    }
}

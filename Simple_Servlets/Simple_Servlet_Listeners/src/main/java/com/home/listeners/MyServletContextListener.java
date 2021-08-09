package com.home.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*If you want to perform some action at the time of deploying
the web application such as creating database connection,
creating all the tables of the project etc,
you need to implement ServletContextListener interface
and provide the implementation of its methods.*/
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(this.getClass().getSimpleName() + ": contextInitialized()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(this.getClass().getSimpleName() + ": contextDestroyed()");
    }
}

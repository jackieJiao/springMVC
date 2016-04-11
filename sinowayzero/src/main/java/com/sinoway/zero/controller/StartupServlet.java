package com.sinoway.zero.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.stereotype.Component;

@Component
public class StartupServlet implements ServletContextInitializer
{
    @Value("${cdn.rootcontext}")
    String cdnRootContext;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        servletContext.setAttribute("cdnRootContext", cdnRootContext);
    }

}

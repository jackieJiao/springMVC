package com.sinoway.zero;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.sinoway.zero.bean.Lygj_dg_detail;
import com.sinoway.zero.service.DGService1;

@Configuration

@EnableAutoConfiguration
@ComponentScan({ "com.sinoway.zero.*" })
@EnableScheduling
public class Application extends SpringBootServletInitializer
{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception
    {
        ApplicationContext appContext= SpringApplication.run(Application.class, args);
        DGService1 dgService1 = appContext.getBean(DGService1.class);
    }

}
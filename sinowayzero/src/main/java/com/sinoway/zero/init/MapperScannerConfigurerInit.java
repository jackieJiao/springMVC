package com.sinoway.zero.init;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperScannerConfigurerInit
{

    private static final String BASE_PACKAGE = "com.sinoway.zero.mapper";

    @Autowired
    private SqlSessionFactoryBean ssfb;

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer()
    {
        MapperScannerConfigurer bean = new MapperScannerConfigurer();
        bean.setSqlSessionFactoryBeanName(SqlSessionFactoryInit.SQL_SESSION_FACTORY_BEAN_NAME);
        bean.setBasePackage(BASE_PACKAGE);
        return bean;
    }
}

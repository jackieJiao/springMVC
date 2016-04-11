package com.sinoway.zero.init;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Component
public class DataSourceInit {

	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
		com.mchange.v2.c3p0.ComboPooledDataSource bean = new com.mchange.v2.c3p0.ComboPooledDataSource();
		try {
			bean.setDriverClass(driverClassName);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		bean.setJdbcUrl(url);
		bean.setUser(username);
		bean.setPassword(password);  
		bean.setMinPoolSize(5);
		bean.setMaxPoolSize(600);
		bean.setInitialPoolSize(5);
		return bean;
	}    
	
//	@Bean  
//	public MultipartResolver multipartResolver()
//	{  
//	    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//	    resolver.setMaxUploadSize( 100 * 15024);
//	    return resolver;
//	}
	  
}

package com.sinoway.zero.init;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class SqlSessionFactoryInit {
	
	public static final String SQL_SESSION_FACTORY_BEAN_NAME = "sqlSessionFactory";
	
	@Autowired
	private DataSource dataSource;
	
	@Bean(name=SQL_SESSION_FACTORY_BEAN_NAME)
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		org.mybatis.spring.SqlSessionFactoryBean bean = new org.mybatis.spring.SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
//		ClassPathResource resource = new ClassPathResource("/sample/jsp/dao/impl/mapper/RoadSectionMapper.xml");
//		Resource[] mapperLocations = new ClassPathResource[]{resource};
//		bean.setMapperLocations(mapperLocations);
		return bean.getObject();
	}  
  
}

package com.member;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
@MapperScan(value = { "com.member.mapper" })
public class MemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}
	
	/*
	 * MyBatis 역시 어노테이션이나 JAVA코드를 이용해서 Mapper인터페이스를 인식하도록 한다.
	 * MyBatis를 사용하기 위해서는 SqlSessionFactory에 대한 설정이 필요하다.
	 * 
	 * XML Mapper를 인식하기 위해서는 SQLSessionFactory을 설정을 변경해줘야 한다.
	 * */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");

		sessionFactory.setMapperLocations(res);

		return sessionFactory.getObject();
	}
}
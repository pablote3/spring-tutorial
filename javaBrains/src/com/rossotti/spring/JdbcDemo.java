package com.rossotti.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rossotti.spring.dao.JdbcDaoImpl;
import com.rossotti.spring.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		
		Circle circle = dao.getCircle(1);
		System.out.println(circle.getName());
	}

}

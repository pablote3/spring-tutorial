package com.rossotti.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rossotti.spring.dao.JdbcDaoImpl;
import com.rossotti.spring.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		
//		Circle circle = dao.getCircle(1);
//		System.out.println(circle.getName());
		
//		System.out.println(dao.getCircleCount());

		//System.out.println(dao.getCircleName(1));
		
//		System.out.println(dao.getCircleForId(1).getName());

		dao.insertCircle(new Circle(5, "Fifth Circle"));
		System.out.println(dao.getAllCircles().size());
		
//		dao.createTriangleTable();
		
	}

}

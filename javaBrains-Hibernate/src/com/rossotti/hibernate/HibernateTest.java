package com.rossotti.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rossotti.dto.Address;
import com.rossotti.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("Second User");
		
		Address addr1 = new Address();
		addr1.setStreet("Street 1");
		addr1.setCity("City 1");
		addr1.setState("State 1");
		addr1.setZipCode("Zip Code 1");
		
		Address addr2 = new Address();
		addr2.setStreet("Street 2");
		addr2.setCity("City 2");
		addr2.setState("State 2");
		addr2.setZipCode("Zip Code 2");
		
		user.getListOfAddresses().add(addr1);
		user.getListOfAddresses().add(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
		session = sessionFactory.openSession();
//		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
//		System.out.println("User Name retrieved is " + user.getUserName());
		
	}
}
package com.rossotti.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rossotti.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetails");
		query.setFirstResult(1);
		query.setMaxResults(2);
		List<UserDetails> users = (List<UserDetails>)query.list();

		
		session.getTransaction().commit();
		session.close();
		
		for (UserDetails u : users) {
			System.out.println(u.getUserName());
		}
		System.out.println("Size = " + users.size());
	}
}
package com.rossotti.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.rossotti.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String minUserId = "1";
//		Query query = session.createQuery("from UserDetails where userId > ?");
//		query.setInteger(0, Integer.parseInt(minUserId));
		
//		Query query = session.getNamedQuery("UserDetails.byId");
//		query.setInteger(0, 1);
//		List<UserDetails> users = (List<UserDetails>)query.list();
		
//		Criteria criteria = session.createCriteria(UserDetails.class);
//		criteria.add(Restrictions.eq("userName", "User2"));	

//		Criteria criteria = session.createCriteria(UserDetails.class)
//									.setProjection(Projections.property("userId"))
//									.addOrder(Order.asc("userId"));
		
//		List<UserDetails> users = (List<UserDetails>)criteria.list();

		UserDetails user = (UserDetails)session.get(UserDetails.class, 1);
		
		UserDetails user2 = (UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
//		for (UserDetails u : users) {
//			System.out.println(u.getUserName());
//		}
//		System.out.println("Size = " + users.size());
	}
}
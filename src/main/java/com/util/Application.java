package com.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.models.User;
import com.models.UserDetails;

public class Application {
	
	
	public void dao()
	{
		Transaction tx = null;
		UserDetails ud = new UserDetails();
		ud.setFname("Jeetesh");
		ud.setMname("Namdeo");
		ud.setLname("Rokade");
		ud.setCountry("India");
		ud.setCity("Mumbai");
		
		User user = new User();
		user.setUd(ud);
		
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			
			tx = session.beginTransaction();
			
			session.save(user);
			
			tx.commit();
		}
		catch(Exception e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
		}
		
	}
	
	

	

}

package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.models.Resource;
import com.models.User;
import com.models.UserDetails;
import com.util.HibernateUtil;

public class UserDAO implements UserInt {

	@Override
	//@Transactional
	public User getUserbyId(int userid) {
		
		Transaction tx= null;
		User user = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			
			tx =session.beginTransaction();
			user = session.get(User.class, userid);
			System.out.println(user);
			tx.commit();

		
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		
		Transaction tx= null;
		List<User>  userlist  = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			
			tx =session.beginTransaction();
			Query q = session.createQuery("FROM USER");
			userlist = q.list();
			System.out.println(userlist);
			tx.commit();

		
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
		}


		return userlist;
		
	
	}

	@Override
	public void addUser(UserDetails ud, String role, Resource resource) {
		Transaction tx = null;
		
		
		User user = new User();
		user.setUd(ud);
		user.setRole(role);
		user.setResource(resource);
		
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

//	@Override
//	public void updateUser(int userid) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void deleteUser(int userid) {
		
		Transaction tx= null;
		UserDAO ud = new UserDAO();
		User user = ud.getUserbyId(userid);
		

		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			
			tx =session.beginTransaction();
		    session.delete(user);
			
			tx.commit();

		
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
		}
	
	}



}

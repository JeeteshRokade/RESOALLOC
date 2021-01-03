package com.dao;

import java.util.ArrayList;
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
	// @Transactional
	public User getUserbyId(String userid) {

		Transaction tx = null;
		User user = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			user =(User) session.get(User.class, userid);
			
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				e.printStackTrace();
				tx.rollback();
			}
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {

		Transaction tx = null;
		List<User> userlist = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			Query q = session.createQuery("FROM USER");
			userlist = q.list();
			System.out.println(userlist);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

		return userlist;

	}

	@Override
	public User addUser(String userid, UserDetails ud, String role, Resource resource)
	{
		Transaction tx = null;
		System.out.println("gdfgfdg1");
		User user = new User();
		user.setUserid(userid);
		user.setUd(ud);
		user.setRole(role);
		//user.getRes().add(resource);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();

			session.save(user);

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

		return user;
	}

//	@Override
//	public void updateUser(int userid) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void deleteUser(String userid) {

		Transaction tx = null;
		UserDAO ud = new UserDAO();
		User user = ud.getUserbyId(userid);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			session.delete(user);

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

	}
	
	@Override
	public void updateResource(String userid, int resourceid) {
		Transaction tx = null;
		ResourceDAO rd = new ResourceDAO();
		Resource resource = rd.getResourcebyId(resourceid);
		UserDAO ud = new UserDAO();
		User user = ud.getUserbyId(userid);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
		
			List<Resource> reslist = new ArrayList<Resource>();
			reslist.add(resource);
			user.setRes(reslist);
			session.update(user);

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}

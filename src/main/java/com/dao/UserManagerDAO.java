package com.dao;
import java.util.*;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.models.Resource;
import com.models.User;
import com.models.UserDetails;
import com.models.UserManager;
import com.util.HibernateUtil;

public class UserManagerDAO implements UserManagerInt {

	@Override
	public UserManager addUserManager(String userid, String managerid,String password) {
		
		UserManager um = new UserManager();
		um.setUserId(userid);
		um.setManagerId(managerid);
		um.setPassword(password);
		Transaction tx=  null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();

			session.save(um);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		return um;
	}

	@Override
	public boolean getuserpass(String UserId, String pass) {

		Transaction tx = null;
		Resource resource = null;
		boolean flag = false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
			tx = session.beginTransaction();
			
//			Query query = session.createQuery("FROM UserManager U WHERE U.UserId =  :UserID");
//			query.setParameter("UserID", UserId);
//			List results = query.getResultList();
			
			UserManager um = session.get(UserManager.class, UserId);
			if( um!=null)
			{
				System.out.println(um.getPassword());
				String password = um.getPassword();
				System.out.println(password.equals(pass));
				if(password.equals(pass))
				{
					System.out.println("PASS");
					flag =true;
					
				}
				else
				{
					flag = false;
				}
			}
			else
			{
				flag = false;
			}
			
			
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

		System.out.println("flag0"+flag);
		return flag;
	}

	@Override
	public String getManagerId(String userid) {
		
		Transaction tx = null;
		UserManager um = null;
        String managerid="";
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			um = session.get(UserManager.class, userid);
			managerid =um.getManagerId();
			System.out.println(um.getManagerId());
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		
		return managerid;
		
	}
	


}

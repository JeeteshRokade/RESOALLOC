package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.models.Resource;
import com.models.ResourceDetails;
import com.models.User;
import com.util.HibernateUtil;

public class ResourceDAO implements ResourceInt {

	@Override
	public Resource getResourcebyId(int resourceid) {

		Transaction tx = null;
		Resource resource = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			resource = session.get(Resource.class, resourceid);
			System.out.println(resource);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

		return resource;

	}

	@Override
	public List<Resource> getAllUsers() {

		Transaction tx = null;
		List<Resource> resourcelist = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			Query q = session.createQuery("FROM RESOURCE");
			resourcelist = q.list();
			System.out.println(resourcelist);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

		return resourcelist;

	}

	@Override
	public void addResource(ResourceDetails rd, User user) {
		Transaction tx = null;

		Resource resource = new Resource();
		resource.setResourcedetails(rd);

		resource.setUser(user);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();

			session.save(resource);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

	}

	@Override
	public void deleteUser(int resourceid) {
		Transaction tx = null;
		ResourceDAO ud = new ResourceDAO();
		Resource resource = ud.getResourcebyId(resourceid);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			session.delete(resource);

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

	}

}

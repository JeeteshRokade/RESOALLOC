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
	public List<Resource> getAllResources() {

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
	public Resource addResource(ResourceDetails rd) 
	{
		Transaction tx = null;

		Resource resource = new Resource();
		resource.setResourcedetails(rd);
		
		

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();

			session.save(resource);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

		return resource;

	}

	@Override
	public void deleteResource(int resourceid) {
		Transaction tx = null;
		ResourceDAO rd = new ResourceDAO();
		Resource resource = rd.getResourcebyId(resourceid);

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

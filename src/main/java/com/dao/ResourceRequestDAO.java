package com.dao;

import java.util.List;

import javax.persistence.NamedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.models.Resource;
import com.models.ResourceRequest;
import com.models.User;
import com.util.HibernateUtil;

public class ResourceRequestDAO implements ResourceRequestInt {

	@Override
	public ResourceRequest getRequesbyId(int requestid) {
		Transaction tx = null;
		ResourceRequest resreq = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			resreq = session.get(ResourceRequest.class, requestid);
			System.out.println(resreq);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

		return resreq;

	}

	@Override
	public List<ResourceRequest> getRequestbyUser(String userid) {
		Transaction tx = null;
		List<ResourceRequest> reslist = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			
			tx = session.beginTransaction();
			
			
			Query q = session.createQuery("FROM ResourceRequest as r WHERE r.user = :quserid ");
			q.setParameter("quserid", userid);
			reslist = q.getResultList();
			
			
			
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

		return reslist;
	}

	@Override
	public List<ResourceRequest> getRequestbyApprover(String approverid) {
		Transaction tx = null;
		List<ResourceRequest> reslist = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			String ticketstatus = "New";
			Query q = session.createQuery("FROM ResourceRequest WHERE approver = :qapproverid AND status = :ticketstatus");
			q.setParameter("qapproverid", approverid);
			q.setParameter("ticketstatus",ticketstatus);
			reslist = q.getResultList();			
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

		return reslist;
	}

	@Override
	public List<ResourceRequest> getAllRequests() {
		Transaction tx = null;
		List<ResourceRequest> reslist = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			Query q = session.createQuery("FROM RESOURCEREQUEST");
			reslist = q.list();
			System.out.println(reslist);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

		return reslist;

	}

	@Override
	public void addRequest(String reason, String status, String user, String approver, Resource resource) {
		Transaction tx = null;

		ResourceRequest resreq = new ResourceRequest();
		resreq.setRequestreason(reason);
		resreq.setStatus(status);
		resreq.setUser(user);
		resreq.setApprover(approver);
		resreq.setResource(resource);
        System.out.println("loaded");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();

			session.save(resreq);
	        System.out.println("saved");
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

	}

	@Override
	public void deleteRequest(int requestid) {
		Transaction tx = null;
//		ResourceRequestDAO rr = new ResourceRequestDAO();
//		ResourceRequest resreq = rr.getRequesbyId(requestid);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			session.delete(session.get(ResourceRequest.class, requestid));

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

	}

	@Override
	public void updaterequeststatus(int requestid, String status) {
		Transaction tx = null;
		ResourceRequestDAO rr = new ResourceRequestDAO();
		ResourceRequest resreq = rr.getRequesbyId(requestid);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			resreq.setStatus(status);
			session.update(resreq);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}

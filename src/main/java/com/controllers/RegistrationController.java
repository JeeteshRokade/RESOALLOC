package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ResourceDAO;
import com.dao.ResourceDetailDAO;
import com.dao.UserDAO;
import com.dao.UserDetailsDAO;
import com.dao.UserManagerDAO;
import com.models.Resource;
import com.models.ResourceDetails;
import com.models.User;
import com.models.UserDetails;
import com.util.HibernateUtil;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView registration(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("registration");
		mv.addObject("userpresnt", "");
		return mv;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView registration(@RequestParam("userid") String userid, @RequestParam("fname") String fname,
			@RequestParam("mname") String mname, @RequestParam("lname") String lname,
			@RequestParam("country") String country, @RequestParam("city") String city,
			@RequestParam("managerid") String managerid, @RequestParam("role") String role,
			@RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		UserManagerDAO umd1 = new UserManagerDAO();
		boolean userpresent = umd1.getuserpass(userid, password);
		System.out.println("reached1");
		if (userpresent == true) {

			ModelAndView mv = new ModelAndView();
			mv.setViewName("registration");
			mv.addObject("userpresent", "User is already present");
			return mv;
		} else {

////		System.out.println(fname + lname + country + city + mname + role);
////
			UserDetailsDAO udd = new UserDetailsDAO();
			UserDetails ud = udd.addUserDetails(fname, mname, lname, country, city);
//		//System.out.println(ud);
//			ResourceDetailDAO rdd = new ResourceDetailDAO();
//			ResourceDetails rd = rdd.addResourceDetails("laptop", "Acer");
//
//			Resource resource = new Resource();
//			resource.setResourcedetails(rd);

//		ResourceDAO rdao = new ResourceDAO();
//		rdao.addResource(rd,user);

			UserDAO udao = new UserDAO();
			User user = udao.addUser(userid, ud, role, null);

//	    
//	    //System.out.println(resource);

			// resource.setUser(user);

			UserManagerDAO umd = new UserManagerDAO();
			umd.addUserManager(userid, managerid, password);

//		Transaction tx = null;
//		System.out.println("gdfgfdg1");
//		User user = new User();
//		user.setUserid(userid);
//		user.setUd(ud);
//		user.setRole(role);
//		user.setResource(resource);
//		System.out.println("gdfgfdg2");
//		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
//
//			tx = session1.beginTransaction();
//
//			session1.save(user);
//
//			tx.commit();
//
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");

		return mv;
		//return "redirect:/login.do";
		}

	}

}

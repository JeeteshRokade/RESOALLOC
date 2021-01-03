package com.controllers;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ResourceDAO;
import com.dao.ResourceDetailDAO;
import com.dao.ResourceRequestDAO;
import com.dao.UserDAO;
import com.dao.UserDetailsDAO;
import com.dao.UserManagerDAO;
import com.models.Resource;
import com.models.ResourceDetails;
import com.models.User;
import com.models.UserDetails;
import com.sun.tools.javac.util.List;
import com.util.HibernateUtil;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView homeget(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		if (session.getAttribute("logged_in") != null) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("home");
			return mv;
		} else {

			ModelAndView mv = new ModelAndView();
			mv.setViewName("login");

			return mv;
		}
	}

//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView homepost(@RequestParam("resourcetype") String resourcetype,
//			@RequestParam("resourcename") String resourcename, @RequestParam("resourcereason") String requestreason,
//			HttpServletResponse response, HttpSession session) {
//
//		UserDAO ud = new UserDAO();
//
//
//		String userid = session.getAttribute("userid").toString();
//		
//
//		//User user = ud.getUserbyId(userid);
//		
//		
//		UserManagerDAO umd = new UserManagerDAO();
//		String managerid = umd.getManagerId(userid);
//		//User approver = ud.getUserbyId(managerid);
//		
//	
//
//		ResourceDetails rd = new ResourceDetails();
//		rd.setResourcename(resourcename);
//		rd.setResourcetype(resourcetype);
////		Resource resource = new Resource();
////		resource.setResourcedetails(rd);
////		resource.setUser(user);
//
//		//ud.updateResource(userid, resource);
//
//		ResourceDAO rdd = new ResourceDAO();
//		Resource resource =rdd.addResource(rd, user);
//		
//        int resourceid  = resource.getResourceid();
//        ud.updateResource(userid, resourceid);;
//
//		
//		ResourceRequestDAO rrd = new ResourceRequestDAO();
//		rrd.addRequest(requestreason, "new", userid, managerid, resource);
//
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home");
//
//		return mv;
//
//	}
//
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView homepost(@RequestParam("resourcetype") String resourcetype,
			@RequestParam("resourcename") String resourcename, @RequestParam("resourcereason") String requestreason,
			HttpServletResponse response, HttpSession session) {

        

			
			
//			  System.out.println("ENTERED2");
//			  
//			UserDetailsDAO udd = new UserDetailsDAO();
//			ResourceDetailDAO rdd1= new ResourceDetailDAO();
//			ResourceDetailDAO rdd2= new ResourceDetailDAO();
//			
//			  System.out.println("ENTERED3");
//			  
//			UserDetails ud = udd.addUserDetails("A", "B", "C", "D", "E");
//			ResourceDetails rd1 = rdd1.addResourceDetails("KACHRA","LAWDA");
//			ResourceDetails rd2= rdd2.addResourceDetails("LACHRA","KAWDA");
//			
//			  System.out.println("ENTERED4");
//			  
//			User u= new User();
//			u.setUserid("SDFdsf");
//			u.setUd(ud);
//			u.setRole("DFddsf");
//			
//			  System.out.println("ENTERED5");
//			  
//			Resource r1 = new Resource();
//			r1.setResourcedetails(rd1);
//			r1.setUseri(u);
//			
//			  System.out.println("ENTERED6");
//			  
//			Resource r2 = new Resource();
//			r2.setResourcedetails(rd2);
//			r2.setUseri(u);
//			
//			  System.out.println("ENTERED7");
//			  
//			ArrayList<Resource> reslist = new ArrayList<Resource>();
//			reslist.add(r1);
//			reslist.add(r2);
//			u.setRes(reslist);
//			
//			  System.out.println("ENTERED8");
//			  try {
//			session1.save(u);
//			  }
//			  catch(Exception e)
//			  {
//				  e.printStackTrace();
//			  }
//			session1.save(r1);
//			session1.save(r2);
			
//			User u = session1.get(User.class,"SDFdsf");
//			for(Resource r:u.getRes())
//			{
//				System.out.println(r);
//			}
//			
			ResourceDetailDAO rdd = new ResourceDetailDAO();
			ResourceDAO  rdao = new ResourceDAO();
			ResourceRequestDAO rrd = new ResourceRequestDAO();
			UserManagerDAO umdao = new UserManagerDAO();
			
			String userid =  session.getAttribute("userid").toString();
			String approverid = umdao.getManagerId(userid);
			
			ResourceDetails rd = rdd.addResourceDetails(resourcetype, resourcename);
			Resource resource = rdao.addResource(rd);
			rrd.addRequest(requestreason, "New",userid, approverid, resource);
	
			ModelAndView mv = new ModelAndView();
		    mv.setViewName("home");
	
		    return mv;

		

	}

}

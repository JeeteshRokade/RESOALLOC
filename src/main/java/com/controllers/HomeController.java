package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ResourceDAO;
import com.dao.ResourceRequestDAO;
import com.dao.UserDAO;
import com.dao.UserManagerDAO;
import com.models.Resource;
import com.models.ResourceDetails;
import com.models.User;

@Controller
//@SessionAttributes("username")
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView registration(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

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

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView home(@RequestParam("resourcetype") String resourcetype,
			@RequestParam("resourcename") String resourcename, @RequestParam("resourcereason") String requestreason,
			HttpServletResponse response, HttpSession session) {

//		Application app = new Application();
//		app.dao();

		UserDAO ud = new UserDAO();
		System.out.println("userid");

		String userid = session.getAttribute("userid").toString();
		System.out.println(userid);

		User user = ud.getUserbyId(userid);
		UserManagerDAO umd = new UserManagerDAO();
		System.out.println(user);

		String managerid = umd.getManagerId(userid);
		User approver = ud.getUserbyId(managerid);
		System.out.println("userid12");
		System.out.println(approver);

		ResourceDetails rd = new ResourceDetails();
		rd.setResourcename(resourcename);
		rd.setResourcetype(resourcetype);
//		Resource resource = new Resource();
//		resource.setResourcedetails(rd);
//		resource.setUser(user);
//		
		ResourceDAO rdd = new ResourceDAO();
		Resource resource = rdd.addResource(rd, user);

		System.out.println(resource);

		System.out.println("userid13");
		ResourceRequestDAO rrd = new ResourceRequestDAO();
		rrd.addRequest(requestreason, "new", userid, managerid, resource);

		System.out.println("userid14");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");

		return mv;

	}

}

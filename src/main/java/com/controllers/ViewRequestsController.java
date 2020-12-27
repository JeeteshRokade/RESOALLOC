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

import com.dao.ResourceRequestDAO;
import com.dao.UserDAO;
import com.dao.UserManagerDAO;
import com.models.User;

import java.util.*;

@Controller
@RequestMapping(value = "/viewreq")
public class ViewRequestsController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView registration(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		if (session.getAttribute("logged_in") != null) {
            
			System.out.println("viewzgsdfsd");
			String userid = session.getAttribute("userid").toString();
			ResourceRequestDAO rrd = new ResourceRequestDAO();
			List requestlist = rrd.getRequestbyUser(userid);
			
			for(Object req : requestlist)
			{
			  System.out.println(req);	
			}
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("viewreq");
			mv.addObject("requestlist", requestlist);
			return mv;
		} else {

			ModelAndView mv = new ModelAndView();
			mv.setViewName("login");

			mv.addObject("badcred", "");

			return mv;
		}
	}

}

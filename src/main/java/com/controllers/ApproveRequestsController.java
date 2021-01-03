package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ResourceRequestDAO;
import com.dao.UserManagerDAO;

@Controller
@RequestMapping(value = "/approvereq")
public class ApproveRequestsController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView approvereqget(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		if (session.getAttribute("logged_in") != null) {

			String userid = session.getAttribute("userid").toString();

			ResourceRequestDAO rrd = new ResourceRequestDAO();
			List requestlist = rrd.getRequestbyApprover(userid);

//			for (Object req : requestlist) {
//				System.out.println(req);
//			}

			ModelAndView mv = new ModelAndView();

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

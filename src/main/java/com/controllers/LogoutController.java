package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout", method = RequestMethod.GET) // ,method = RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if (session.getAttribute("logged_in") != null) {

			session.removeAttribute("logged_in");
			session.removeAttribute("userid");
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("logout");

		return mv;
	}

}

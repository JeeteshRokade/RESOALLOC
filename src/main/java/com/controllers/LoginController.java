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

import com.dao.UserDAO;
import com.dao.UserManagerDAO;
import com.models.User;

@Controller

@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loginget(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		if (session.getAttribute("logged_in") != null) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("home");
			return mv;
		} else {

			ModelAndView mv = new ModelAndView();
			mv.setViewName("login");

			mv.addObject("badcred", "");

			return mv;
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginpost(@RequestParam("userid") String userid, @RequestParam("pass") String password,
			HttpServletResponse response, HttpSession session) {

//		UserDAO userdao =new UserDAO();
//		User user = userdao.getUserbyId("jeetesh");
//		System.out.println(user);

		UserManagerDAO umd = new UserManagerDAO();

		boolean userpresent = umd.getuserpass(userid, password);

		if (userpresent == true) {
			session.setAttribute("userid", userid);
			session.setAttribute("logged_in", "yes");

			ModelAndView mv = new ModelAndView();
			mv.setViewName("home");

			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("login");
			mv.addObject("badcred", "Enter valid credentials");
			return mv;
		}

	}

}

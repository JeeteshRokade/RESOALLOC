package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.util.Application;

@Controller
public class HomeController {

	@RequestMapping("/home") // ,method = RequestMethod.POST)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {

		Application app = new Application();
		app.dao();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");

		return mv;
	}

}

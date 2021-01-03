package com.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ResourceDAO;
import com.dao.ResourceRequestDAO;
import com.dao.UserDAO;

@Controller
@RequestMapping(value = "/changestatus")
public class ChangeStatusController {

	@RequestMapping(method = RequestMethod.POST)
	public String changestatuspost(@RequestParam("requestid") int requestid, @RequestParam("resourceid") int resourceid,
			@RequestParam("userid") String userid, @RequestParam("status") String status, HttpServletResponse response,
			HttpSession session) {

		if(status.equals("Approved"))
		{
			System.out.println("Dgf");
		ResourceRequestDAO rrd = new ResourceRequestDAO();  	
		rrd.updaterequeststatus(requestid, status);
	    UserDAO ud = new UserDAO();
		ud.updateResource(userid, resourceid);
//		ResourceDAO rd= new ResourceDAO();
//		rd.updateUser(resourceid, userid);
		}
		else if(status.equals( "Rejected"))
		{
			System.out.println("Dgf1");
			ResourceRequestDAO rrd = new ResourceRequestDAO();  	
			ResourceDAO rd = new ResourceDAO();
			
			rd.deleteResource(resourceid);
			rrd.deleteRequest(requestid);
			
		}

		return "redirect:/approvereq.do";
	}

}

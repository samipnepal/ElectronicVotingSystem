package com.wipro.evs.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.service.Administrator;
import com.wipro.evs.service.impl.AdministratorImpl;


@Controller
public class AdminController {
	Administrator ad=new AdministratorImpl();
	

	@RequestMapping(value = "VoterIDRequests", method = RequestMethod.GET)
	public String home(ModelMap model) {
		ArrayList<ApplicationBean> list=ad.viewAllAdminPendingApplications();
		model.addAttribute("list", list);
		return "admin/voterIDRequest";
		
	}

	@RequestMapping(value = "approveVoterID/{userID}", method = RequestMethod.GET)
	public String login(@PathVariable("userID") String userID,
 ModelMap model) {
		boolean flag=ad.forwardVoterIDRequest(userID);
		if(flag)
		{
			ArrayList<ApplicationBean> list=ad.viewAllAdminPendingApplications();
			model.addAttribute("list", list);
			model.addAttribute("msg", "VoterID Request Passes To Electrol Successfully");
			return "admin/voterIDRequest";
		}
		else
		{
			ArrayList<ApplicationBean> list=ad.viewAllAdminPendingApplications();
			model.addAttribute("list", list);
			model.addAttribute("msg", "VoterID Request Passing Failed");
			return "admin/voterIDRequest";
		}		
	}
	
	
}

package com.wipro.evs.controller;

import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.service.Administrator;
import com.wipro.evs.service.ElectoralOfficer;
import com.wipro.evs.service.impl.AdministratorImpl;
import com.wipro.evs.service.impl.ElectrolOfficerImpl;

@Controller
public class ElectrolController {
	Administrator ad = new AdministratorImpl();
	ElectoralOfficer eo=new ElectrolOfficerImpl();
	
	
	@RequestMapping(value = "voterIDRequestAdmin", method = RequestMethod.GET)
	public String voterIDRequestAdmin( ModelMap model) {
				ArrayList<ApplicationBean> list=eo.viewAllVoterIdApplications();
				model.addAttribute("list", list);
				return "electrol/viewVoterRequest";

	}
	
	@RequestMapping(value = "approveVoterIDAdmin/{userID}/{status}", method = RequestMethod.GET)
	public String approveVoterIDAdmin(@PathVariable("userID") String userID,@PathVariable("status") String status, ModelMap model) {
				String result=eo.generateVoterId(userID, status);
				ArrayList<ApplicationBean> list=eo.viewAllVoterIdApplications();
				model.addAttribute("list", list);
				model.addAttribute("msg", "Generated Voter ID is: "+result);
				return "electrol/viewVoterRequest";
	}
	
	
	
	
	
	
}

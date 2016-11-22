package com.wipro.evs.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.service.Administrator;
import com.wipro.evs.service.impl.AdministratorImpl;


@Controller
public class ElectionController {
	Administrator ad=new AdministratorImpl();
	
	@RequestMapping(value = "addElection",method = RequestMethod.GET)
	public ModelAndView registerPage(@ModelAttribute("loginuser")CredentialsBean cbean) {
		return new ModelAndView("admin/addElection", "election", new ElectionBean());
	}
	
	@RequestMapping(value = "addElection",method = RequestMethod.POST)
	public String profileRegister(@ModelAttribute("election")@Valid ElectionBean ebean,BindingResult result,
			 ModelMap model) {
			if(result.hasErrors())
			{
				return "addElection";
			}
			String type=ad.addElection(ebean);
			if(type.equals("SUCCESS")){
				model.addAttribute("msg", "Election Added Successfully");
				return "admin/addElection";
			}
			else
				model.addAttribute("error", "Failed To Add Election");
				return "admin/addElection";
	}
	@RequestMapping(value = "viewAllElection",method = RequestMethod.GET)
	public String viewAllElection(HttpSession session) {
			ArrayList<ElectionBean> array=new ArrayList<ElectionBean>();
			array=ad.viewElections();
			session.setAttribute("list", array);
			return "admin/viewAllElection";
	}
	@RequestMapping(value = "upcomingElection",method = RequestMethod.GET)
	public String upcomingElection(HttpSession session) {
			ArrayList<ElectionBean> array=new ArrayList<ElectionBean>();
			array=ad.viewAllUpcomingElections();
			session.setAttribute("list", array);
			return "admin/upcomingElection";
	}
	
	
}

package com.wipro.evs.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.service.Administrator;
import com.wipro.evs.service.impl.AdministratorImpl;

@Controller
public class CandidateController {
	Administrator ad = new AdministratorImpl();

	@RequestMapping(value = "assignCandidate", method = RequestMethod.GET)
	public ModelAndView home(ModelMap model) {
		ArrayList<ElectionBean> list = ad.viewAllUpcomingElections();
		ArrayList<PartyBean> partylist = ad.viewAllParty();
		model.addAttribute("electionList", list);
		model.addAttribute("partyList", partylist);
		return new ModelAndView("admin/assignCandidate", "candidate", new CandidateBean());
	}

	@RequestMapping(value = "assignCandidate", method = RequestMethod.POST)
	public String login(@ModelAttribute("candidate") CandidateBean cbean, ModelMap model) {
		String result = ad.addCandidate(cbean);
		
		if (result.equals("SUCCESS")) {
			model.addAttribute("msg", "Candidate Added Successfully");
			return "admin/assignCandidate";
		}
		else{
			model.addAttribute("error", "Error Adding Candidate");
			return "admin/assignCandidate";
		}
			

	}

}

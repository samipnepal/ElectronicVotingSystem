package com.wipro.evs.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.evs.bean.ApplicationBean;
import com.wipro.evs.bean.CandidateBean;
import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.bean.ElectionBean;
import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.bean.ResultBean;
import com.wipro.evs.dao.ProfileDAO;
import com.wipro.evs.dao.impl.ProfileDAOImpl;
import com.wipro.evs.service.Administrator;
import com.wipro.evs.service.Voter;
import com.wipro.evs.service.impl.AdministratorImpl;
import com.wipro.evs.service.impl.VoterImpl;

@Controller
public class VoterController {
	Voter vo = new VoterImpl();
	Administrator ad = new AdministratorImpl();
	ProfileDAO pd=new ProfileDAOImpl();
	

	@RequestMapping(value = "voterProfile", method = RequestMethod.GET)
	public ModelAndView home(	ModelMap model, HttpSession session) {
		if(session.getAttribute("evsuser")!=null){
			CredentialsBean cb=(CredentialsBean)session.getAttribute("evsuser");
			ProfileBean pb=pd.findByID(cb.getUserID());
			return new ModelAndView("voter/voter", "profile", pb);
			
		}
			
		return new ModelAndView("index", "loginuser",new CredentialsBean());
		

	}
	
	
	

	@RequestMapping(value = "requestVoterId", method = RequestMethod.GET)
	public ModelAndView reqVoter(HttpSession session, ModelMap model) {
		ArrayList<ElectionBean> list = vo.viewListOfElections();
		model.addAttribute("constituencyList", list);
		return new ModelAndView("voter/requestVoterId", "reqVoterId",new ApplicationBean());
	}

	@RequestMapping(value = "requestVoterId", method = RequestMethod.POST)
	public String login(@ModelAttribute("reqVoterId") ApplicationBean aBean,
			ModelMap model, HttpSession session) {
		String result = "";
		if (session.getAttribute("evsuser") != null) {
			CredentialsBean cBean = (CredentialsBean) session
					.getAttribute("evsuser");
			aBean.setUserID(cBean.getUserID());
			aBean.setPassedStatus(1);
			result = vo.requestVoterId(aBean);
		}
		if (result.equals("SUCCESS")) {
			return "voter/voter";
		} else {
			return "voter/voter";
		}

	}

	@RequestMapping(value = "upcomingVoterElection", method = RequestMethod.GET)
	public String upcomingElection(HttpSession session) {
		ArrayList<ElectionBean> array = new ArrayList<ElectionBean>();
		array = ad.viewAllUpcomingElections();
		session.setAttribute("list", array);
		return "voter/upcomingElection";
	}

	@RequestMapping(value = "viewVoterID", method = RequestMethod.GET)
	public String viewVoterID(ModelMap model, HttpSession session) {
		ApplicationBean aBean = null;
		if (session.getAttribute("evsuser") != null) {
			CredentialsBean cBean = (CredentialsBean) session
					.getAttribute("evsuser");
			aBean = vo.viewGeneratedVoterId(cBean.getUserID());

		}
		if (aBean != null) {
			model.addAttribute("aBean", aBean);
			return "voter/viewVoterID";
		} else {
			model.addAttribute("error", "No Voter Id Requested");
			return "voter/viewVoterID";
		}
	}
	@RequestMapping(value = "castVote", method = RequestMethod.GET)
	public ModelAndView castVote(HttpSession session) {
		ArrayList<ElectionBean> array = new ArrayList<ElectionBean>();
		array = vo.viewCurrentElections();
		String ElectionID="";
		java.util.Iterator<ElectionBean> i=array.iterator();
		while(i.hasNext())
		{
			ElectionBean e=i.next();
			ElectionID=e.getElectionID();
			
		}
		ArrayList<CandidateBean> array1 = new ArrayList<CandidateBean>();
		array1 = vo.viewCandidatesByElectionName(ElectionID);
		session.setAttribute("candidateList", array1);
		session.setAttribute("electionList", array);
		
		return new ModelAndView("voter/castVote", "castVote",new ResultBean());

	}
	
	
	@RequestMapping(value = "castVote", method = RequestMethod.POST)
	public ModelAndView candidateList(@ModelAttribute("castVote") ResultBean rBean,	ModelMap model) {
		
		
		model.addAttribute("msg","Vote Casted");
		return new ModelAndView("voter/castVote", "castVote",new ResultBean());
	}


}

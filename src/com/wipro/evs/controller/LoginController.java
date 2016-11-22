package com.wipro.evs.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.util.impl.UserImpl;

@Controller
@RequestMapping(value = "/login")
@SessionAttributes(value="evsuser")
public class LoginController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(HttpSession session, ModelAndView model) {
		CredentialsBean cbean = new CredentialsBean();
		if(session.getAttribute("evsuser")!=null)
		{
			cbean=(CredentialsBean) session.getAttribute("evsuser");
		}
		return new ModelAndView("index", "loginuser", cbean);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(@ModelAttribute("loginuser") CredentialsBean cbean, HttpSession session,
			 ModelMap model) {
		if (cbean.getUserID() == "" || cbean.getPassword() == "") {
			model.addAttribute("user", "Username or password cannot be empty");
			return "index";
		}
		if (cbean.getUserID().length() != 6) {
			model.addAttribute("user", "Username must be 6 character");
			return "index";
		}
		if (cbean.getPassword().length() < 6) {
			model.addAttribute("user", "Password must be at least 6 character");
			return "index";
		}
		model.addAttribute("loginuser");
		String type=null;
		UserImpl uim = new UserImpl();
		if(session.getAttribute("evsuser")!=null)
		{
			cbean=(CredentialsBean) session.getAttribute("evsuser");
			type=cbean.getUserType();
		}
		else{
		type = uim.login(cbean);
		}
		if (type == null) {
			model.addAttribute("user", "Invalid Username and Password");
			return "index";
		}
		if (type.equals("A")){
			cbean.setUserType("A");
			session.setAttribute("evsuser", cbean);
		
			return "admin/admin";
		}
		if (type.equals("E")){
			cbean.setUserType("E");
			session.setAttribute("evsuser", cbean);
			return "electrol/electrol";
		}
		if(type.equals("V")){
			cbean.setUserType("V");
			session.setAttribute("evsuser", cbean);
			return "redirect:/voterProfile";
		}
		if(type.equals("FAIL")){
			model.addAttribute("user", "User is already logged in another system");
			return "index";
		}
		else{
			model.addAttribute("user", "Invalid Username and Password");
			return "index";
		}
	}
	

}

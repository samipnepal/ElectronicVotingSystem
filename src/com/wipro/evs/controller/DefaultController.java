package com.wipro.evs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.evs.bean.CredentialsBean;

@Controller
@RequestMapping(value = "/*")
public class DefaultController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(HttpSession session, ModelAndView model) {
		CredentialsBean cbean = new CredentialsBean();
		if(session.getAttribute("evsuser")!=null)
		{
			cbean=(CredentialsBean) session.getAttribute("evsuser");
		}
		return new ModelAndView("index", "loginuser", cbean);
	}

}

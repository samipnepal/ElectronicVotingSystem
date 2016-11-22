package com.wipro.evs.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.bean.ProfileBean;
import com.wipro.evs.util.impl.UserImpl;


@Controller
@RequestMapping(value = "/registerUser")
public class UserRegisterController {	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView registerPage() {
		ProfileBean pbean = new ProfileBean();
		return new ModelAndView("user/userRegistration", "registerUser", pbean);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView profileRegister(@ModelAttribute("registerUser")@Valid ProfileBean pbean,BindingResult result,
			 ModelMap model) {
			if(result.hasErrors())
			{
				return new ModelAndView("user/userRegistration", "registerUser", pbean);
			}
		UserImpl uim = new UserImpl();
		String userid=uim.register(pbean);
			model.addAttribute("msg", "Successfully Added,  Your UserID is: "+userid);
			return new ModelAndView("index", "loginuser", new CredentialsBean());
	}
}

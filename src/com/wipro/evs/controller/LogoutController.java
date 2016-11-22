package com.wipro.evs.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.util.User;
import com.wipro.evs.util.impl.UserImpl;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView logout(HttpSession httpsession) {
		User us=new UserImpl();
		if(httpsession.getAttribute("evsuser")==null)
			return new ModelAndView("index", "loginuser", new CredentialsBean());
		CredentialsBean cb=(CredentialsBean) httpsession.getAttribute("evsuser");
		us.logout(cb.getUserID());
		httpsession.removeAttribute("evsuser");
		return new ModelAndView("index", "loginuser", new CredentialsBean());
	}
}

package com.wipro.evs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.evs.bean.CredentialsBean;
import com.wipro.evs.util.User;
import com.wipro.evs.util.impl.UserImpl;




@Controller
@RequestMapping(value = "/changePassword")
public class ChangePassController {
	
	User ui=new UserImpl();

		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView home(HttpSession session, ModelMap model) {
			CredentialsBean cbean = new CredentialsBean();
			if(session.getAttribute("evsuser")!=null)
			{
				cbean=(CredentialsBean) session.getAttribute("evsuser");
				return new ModelAndView("user/changePassword", "changepass", cbean);
			}
			else
				model.addAttribute("user", "User is not logged In, Please Login.");
				return new ModelAndView("index", "loginuser", cbean);
				
	}
		
		@RequestMapping(method = RequestMethod.POST)
		public String login(HttpSession session, 
				@RequestParam("newpass") String newpass, @RequestParam("cfgpass") String cfgpass, 
				@RequestParam("oldpass") String oldpass, ModelMap model) {
			String result=null;
			CredentialsBean cbean=(CredentialsBean)session.getAttribute("evsuser");
			if(cfgpass.equals(newpass))
			{
				if(cbean.getPassword().equals(oldpass)){		
					result=ui.changePassword(cbean, newpass);
				}
				else
				{
					model.addAttribute("user", "Invalid Old Password");
					return "user/changePassword";
				}
			}
			if(result.equals("SUCCESS"))
			{
				session.removeAttribute("evsuser");
				model.addAttribute("msg", "Password Changed Successfully");
				return "redirect:/login";
			}
			else
			{
				model.addAttribute("user", "Password Doesn't match");
				return "user/changePassword";
			}
					
			
		}


}

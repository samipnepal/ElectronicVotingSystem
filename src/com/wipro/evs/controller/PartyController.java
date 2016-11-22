package com.wipro.evs.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.evs.bean.PartyBean;
import com.wipro.evs.service.Administrator;
import com.wipro.evs.service.impl.AdministratorImpl;

@Controller
public class PartyController {
	Administrator ad = new AdministratorImpl();

	@RequestMapping(value = "addParty", method = RequestMethod.GET)
	public ModelAndView party(HttpSession session, ModelMap model) {

		PartyBean pbean = new PartyBean();
		return new ModelAndView("admin/addParty", "addParty", pbean);

	}

	@RequestMapping(value = "addParty", method = RequestMethod.POST)
	public String addParty(@ModelAttribute("addParty") PartyBean pbean,
			@RequestParam("file") MultipartFile file, ModelMap model) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String result = "";
		String fileName = file.getOriginalFilename();

		try {
			inputStream = file.getInputStream();
			File newFile = new File("C:/Users/user/Desktop/images/", fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			pbean.setSymbol(fileName);
			result = ad.addParty(pbean);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (result.equals("SUCCESS")) {
			model.addAttribute("msg", "Party Added Successfully");
			return "admin/admin";
		} else {
			model.addAttribute("msg", "Error Adding Party");
			return "admin/admin";
		}

	}
	@RequestMapping(value = "allParty", method = RequestMethod.GET)
	public String allParty(ModelMap model) {
		ArrayList<PartyBean> list=	ad.viewAllParty();
		model.addAttribute("list", list);
		return "admin/allParty";
	}

}

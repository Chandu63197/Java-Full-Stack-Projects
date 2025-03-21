package org.jsp.springmvc.controller;

import org.jsp.springmvc.dao.UserDao;
import org.jsp.springmvc.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	private UserDao dao;
	
	@RequestMapping(value = "/open-view")
	public String openView(@RequestParam String view) {
       return view;
	}
	
	@RequestMapping(value="/load")
	public ModelAndView load(@RequestParam String page) {
		ModelAndView view=new ModelAndView();
		view.setViewName(page);
		view.addObject("u", new User());
		return view;
	}
	
	@PostMapping("/register")
	@ResponseBody
	public String saveUser(@ModelAttribute(name="u") User user) {
		user=dao.saveUser(user);
		return "User saved with id:"+user.getId();
	}
	
	@PostMapping("/update")
	@ResponseBody
	public String updateUser(@ModelAttribute(name = "u") User user) {
		user = dao.updateUser(user);
		return "User Updated with Id:" + user.getId();
	}
	
	@PostMapping(value="/verify-phone")
	public ModelAndView verify(@RequestParam long phone,@RequestParam String password) {
		User u=dao.verify(phone, password);
		ModelAndView view=new ModelAndView();
		if(u!=null) {
			view.setViewName("print");
			view.addObject("data", u);
			return view;
		}
		else {
			view.setViewName("error");
			view.addObject("message", "Invalid Phone and Password");
			return view;
		}
	}
}

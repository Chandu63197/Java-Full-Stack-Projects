package org.jsp.usermvcdemo.controller;

import org.jsp.usermvcdemo.dao.UserDao;
import org.jsp.usermvcdemo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value="/find")
	public ModelAndView findById(@RequestParam int id) {
		User u=dao.findById(id);
		ModelAndView view=new ModelAndView();
		if(u!=null) {
			view.setViewName("print");
			view.addObject("data", u);
			return view;
		}
		else {
			view.setViewName("error");
			view.addObject("message", "Invalid Id");
			return view;
		}
	}
	
	@PostMapping(value="/verify-by-phone")
	public ModelAndView verify(@RequestParam long phone,@RequestParam String password) {
		User u=dao.verifyId(phone, password);
		ModelAndView view=new ModelAndView();
		if(u!=null) {
			view.setViewName("print");
			view.addObject("data", u);
			return view;
		}
		else {
			view.setViewName("error");
			view.addObject("message", "Invalid Id");
			return view;
		}
	}
	
	@PostMapping(value="/verify-by-id")
	public ModelAndView verify(@RequestParam int id,@RequestParam String password) {
		User u=dao.verifyId(id, password);
		ModelAndView view=new ModelAndView();
		if(u!=null) {
			view.setViewName("print");
			view.addObject("data", u);
			return view;
		}
		else {
			view.setViewName("error");
			view.addObject("message", "Invalid Id");
			return view;
		}
	}

	@PostMapping(value="/verify-by-email")
	public ModelAndView verify(@RequestParam String email,@RequestParam String password) {
		User u=dao.verifyEmail(email, password);
		ModelAndView view=new ModelAndView();
		if(u!=null) {
			view.setViewName("print");
			view.addObject("data", u);
			return view;
		}
		else {
			view.setViewName("error");
			view.addObject("message", "Invalid Id");
			return view;
		}
	}
	
	@GetMapping(value="/delete")
	@ResponseBody
	public String deleteById(@RequestParam int id) {
		User u=dao.findById(id);
		if(u!=null) {
			dao.delete(id);
			return "user deleted";
		}
		else {
		    return "Invalid Id";
		}
	}


}

package org.jsp.springmvcdemo.controller;

import org.jsp.springmvcdemo.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = "/open-home")
	public String openHome(@RequestParam(name = "view") String page) {
		return page;
	}

	@RequestMapping(value = "/getSum")
	public String findSum(@RequestParam int n1, @RequestParam int n2, Model model) {
		model.addAttribute("result", "The sum is:" + (n1 + n2));
		return "print";
	}

	@RequestMapping(value = "/getDiff")
	public String findDiff(@RequestParam int n1, @RequestParam int n2, Model model) {
		model.addAttribute("result", "The sum is:" + (n1 - n2));
		return "print";
	}

	@RequestMapping(value = "/getProd")
	public String findProd(@RequestParam int n1, @RequestParam int n2, Model model) {
		model.addAttribute("result", "The sum is:" + (n1 * n2));
		return "print";
	}

	@RequestMapping(value = "/getQuot")
	public String findQuot(@RequestParam int n1, @RequestParam int n2, Model model) {
		model.addAttribute("result", "The sum is:" + (n1 / n2));
		return "print";
	}

	@RequestMapping(value = "/getRem")
	public String findRem(@RequestParam int n1, @RequestParam int n2, Model model) {
		model.addAttribute("result", "The sum is:" + (n1 % n2));
		return "print";
	}

	@RequestMapping(value = "/register")
	@ResponseBody
	public String printData(@RequestParam String name, @RequestParam long phone, @RequestParam String email,
			@RequestParam int age, @RequestParam String gender, @RequestParam String password) {
       System.out.println("Name:"+name);
       System.out.println("Phone Number:"+phone);
       System.out.println("Age:"+age);
       System.out.println("Email:"+email);
       System.out.println("Gander:"+gender);
       System.out.println("Password:"+password);
       return "Data has been Printed";
	}
	
	@RequestMapping("open-register")
	public ModelAndView openRegister() {
		ModelAndView view=new ModelAndView();
		view.setViewName("register");
		view.addObject("u",new User());
		return view;
	}
}

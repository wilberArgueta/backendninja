package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.model.UsersModel;

@Controller
public class LoginController {

	private final String LOGIN_VIEW = "login";

	@GetMapping("/")
	public String redirect() {

		return "redirect:/login";
	}

	@GetMapping("/login")
	public ModelAndView showLoginForm(Model m, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		m.addAttribute("error", error);
		m.addAttribute("logout", logout);
		m.addAttribute("usersModel", new UsersModel());
		ModelAndView mav = new ModelAndView(LOGIN_VIEW);

		return mav;
	}

}

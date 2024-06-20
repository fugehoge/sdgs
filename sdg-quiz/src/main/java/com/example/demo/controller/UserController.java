package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller

public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String showSignUpForm(Model model)
	{
		model.addAttribute("user",new User());
		return "signup";
	}

	@PostMapping("signup")
	public String signUp(@ModelAttribute User user)
	{
		userService.save(user);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLongForm()
	{
		return "login";
	}
	
    @GetMapping("/account")
    public String showAccountPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.fidByUsername(username);
        model.addAttribute("user", user);
        return "account";
	}
	
}

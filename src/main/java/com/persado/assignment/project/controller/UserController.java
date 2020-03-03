package com.persado.assignment.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/userForm")
	public String createUserPage() {
		return "userForm";
	}

	@RequestMapping("/users")
	public String showUsersPage() {
		return "showUsers";
	}

}

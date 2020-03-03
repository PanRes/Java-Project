package com.persado.assignment.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping({"userForm","/userForm","/userForm.html","user/userForm","user/userForm.html","/user/userForm",
			"/user/userForm.html", "user/createForm", "/user/createForm", "user/createForm.hmtl", "/user/createForm.html"})
	public String createUserPage() {
		return "user/userForm";
	}

	@RequestMapping({"user","/user","/user.html","user/index","user/index.html","/user/index","/user/index.html"})
	public String showUsersPage() {
		return "user/index";
	}

}

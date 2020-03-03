package com.persado.assignment.project.controller;

import com.persado.assignment.project.model.dto.UserDto;
import com.persado.assignment.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserService userService;

	@RequestMapping({"userForm", "/userForm", "/userForm.html", "user/userForm", "user/userForm.html", "/user/userForm",
			"/user/userForm.html", "user/createForm", "/user/createForm", "user/createForm.hmtl", "/user/createForm.html"})
	public String createUserPage(Model model) {

		model.addAttribute("user", new UserDto());
		return "user/userForm";
	}

	@RequestMapping({"user", "/user", "/user.html", "user/index", "user/index.html", "/user/index", "/user/index.html"})
	public String showUsersPage() {
		return "user/index";
	}

	@PostMapping("/user")
	public String saveUser(@Valid UserDto userDto) {
		userService.saveUser(userDto);

		return "redirect:/users";
	}

}

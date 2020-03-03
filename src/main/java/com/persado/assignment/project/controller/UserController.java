package com.persado.assignment.project.controller;

import com.persado.assignment.project.model.dto.UserDto;
import com.persado.assignment.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.CannotProceedException;
import javax.validation.Valid;
import java.util.UUID;

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

	@GetMapping({"users","/users","/users.html","users/index","users/index.html","/users/index","/users/index.html"})
	public String showUsersPage(Model model) {

		model.addAttribute("users", userService.getUsers());
		return "user/index";
	}
	@RequestMapping("/user/cannot-delete")
	public String errorOnUserDeletion(Model model) {
		model.addAttribute("user", userService.findUserById((UUID) model.asMap().get("userId")));
		return "user/errorDeletion";
	}

	@RequestMapping("/user/{userId}")
	public String deleteUser(@PathVariable UUID userId, Model model) {
		try {
			userService.deleteUser(userId);
			return "redirect:/users";
		} catch (CannotProceedException e) {
			model.addAttribute("userId", userId);
			return "redirect:/use/cannot-delete";
		}

	}

	@PostMapping("/user")
	public String saveUser(@Valid UserDto userDto) {
		userService.saveUser(userDto);

		return "redirect:/users";
	}

}

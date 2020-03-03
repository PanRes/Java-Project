package com.persado.assignment.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@RequestMapping("/bookForm")
	public String createBookPage() {
		return "bookForm";
	}

	@RequestMapping("/books")
	public String showBooksPage() {
		return "showBooks";
	}

	@RequestMapping("/loan")
	public String loanBookPage() {
		return "loan";
	}



}

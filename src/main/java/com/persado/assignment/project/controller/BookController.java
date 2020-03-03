package com.persado.assignment.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@RequestMapping({"bookForm","/bookForm","/bookForm.html","book/bookForm","book/bookForm.html","/book/bookForm",
			"/book/bookForm.html", "book/createForm", "/book/createForm", "book/createForm.hmtl", "/book/createForm.html"})
	public String createBookPage() {
		return "book/bookForm";
	}

	@RequestMapping({"user","/user","/user.html","user/index","user/index.html","/user/index","/user/index.html"})
	public String showBooksPage() {
		return "book/index";
	}

	@RequestMapping({"loan", "/loan", "loan.html", "/loan.html", "book/loan", "/book/loan", "book/loan.html", "/book/loan.html"})
	public String loanBookPage() {
		return "book/loan";
	}

	@RequestMapping({"returnBook", "/returnBook", "returnBook.html", "/returnBook.html", "book/return", "/book/return", "book/return.html", "/book/return.html"})
	public String returnBookPage() {
		return "book/return";
	}


}

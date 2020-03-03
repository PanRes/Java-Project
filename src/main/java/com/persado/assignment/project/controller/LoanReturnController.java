package com.persado.assignment.project.controller;

import com.persado.assignment.project.model.dto.LoanReturnForm;
import com.persado.assignment.project.service.LoanReturnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class LoanReturnController {

	private final LoanReturnService loanReturnService;

	@GetMapping({"loan", "loan.html", "/loan", "/loan.html",
			"book/loan", "book/loan.html", "/book/loan", "/book/loan.html"})
	public String loanBookPage(Model model) {

		model.addAttribute("loanReturnForm", new LoanReturnForm());
		model.addAttribute("loanReturns", loanReturnService.getBooksForLoan());

		return "book/loan";
	}

	@PostMapping({"loan", "loan.html", "/loan", "/loan.html",
			"book/loan", "book/loan.html", "/book/loan", "/book/loan.html"})
	public String loanBook(LoanReturnForm form) {

		loanReturnService.loanBook(form);

		return "redirect:/loan";
	}

	@GetMapping({"returnBook", "/returnBook", "returnBook.html", "/returnBook.html", "book/return", "/book/return",
			"book/return.html", "/book/return.html"})
	public String returnBookPage() {
		return "book/return";
	}

}

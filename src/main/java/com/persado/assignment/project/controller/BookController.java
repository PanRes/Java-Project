package com.persado.assignment.project.controller;

import com.persado.assignment.project.model.dto.BookDto;
import com.persado.assignment.project.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class BookController {

	private final BookService bookService;

	@RequestMapping({"bookForm", "/bookForm", "/bookForm.html", "book/bookForm", "book/bookForm.html", "/book/bookForm",
			"/book/bookForm.html", "book/createForm", "/book/createForm", "book/createForm.hmtl", "/book/createForm.html"})
	public String createBookPage(Model model) {

		model.addAttribute("book", new BookDto());
		return "book/bookForm";
	}

	@GetMapping(
			{"books", "/books", "/books.html", "books/index", "books/index.html", "/books/index", "/books/index.html"})
	public String showBooksPage() {
		return "book/index";
	}

	@RequestMapping(
			{"loan", "/loan", "loan.html", "/loan.html", "book/loan", "/book/loan", "book/loan.html", "/book/loan.html"})
	public String loanBookPage() {
		return "book/loan";
	}

	@RequestMapping(
			{"returnBook", "/returnBook", "returnBook.html", "/returnBook.html", "book/return", "/book/return", "book/return.html", "/book/return.html"})
	public String returnBookPage() {
		return "book/return";
	}

	@PostMapping("book")
	public String createBook(@Valid BookDto book) {
		bookService.saveBook(book);

		return "redirect:/books";
	}

}

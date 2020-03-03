package com.persado.assignment.project.controller;

import com.persado.assignment.project.model.dto.BookDto;
import com.persado.assignment.project.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.CannotProceedException;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class BookController {

	private final BookService bookService;

	@ModelAttribute("books")
	public List<BookDto> getBooks() {
		return bookService.getBooks();
	}

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

	@PostMapping("book")
	public String createBook(@Valid BookDto book) {
		bookService.saveBook(book);

		return "redirect:/books";
	}

	@GetMapping("/book/{bookId}")
	public String deleteUser(@PathVariable UUID bookId) throws CannotProceedException {
		bookService.deleteBook(bookId);

		return "redirect:/books";
	}

}
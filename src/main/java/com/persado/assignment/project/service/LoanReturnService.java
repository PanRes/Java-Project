package com.persado.assignment.project.service;

import com.persado.assignment.project.converter.BookConverter;
import com.persado.assignment.project.converter.UserConverter;
import com.persado.assignment.project.model.dto.BookDto;
import com.persado.assignment.project.model.dto.LoanReturnForm;
import com.persado.assignment.project.model.dto.LoanReturnResult;
import com.persado.assignment.project.model.dto.UserDto;
import com.persado.assignment.project.model.entity.Book;
import com.persado.assignment.project.model.entity.User;
import com.persado.assignment.project.repository.BookRepository;
import com.persado.assignment.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LoanReturnService {

	private final UserRepository userRepository;
	private final BookRepository bookRepository;
	private final BookConverter bookConverter;
	private final UserConverter userConverter;

	public List<LoanReturnResult> getBooksForLoan() {
		List<BookDto> books = bookConverter.toDtosList(bookRepository.findBooksByAvailableGreaterThan(0));
		List<UserDto> users = userConverter.toDtosList(userRepository.findAll());

		List<LoanReturnResult> loanReturns = books.stream()
				.map(LoanReturnResult::new)
				.collect(Collectors.toList());

		loanReturns.forEach(loanReturn -> loanReturn.setUsers(users.stream()
				.filter(user -> !loanReturn.getBook().getUsers().stream().anyMatch(userDto -> userDto.equals(user)))
				.collect(Collectors.toList())));

		return loanReturns;
	}

	public void loanBook(LoanReturnForm loanBook) {
		User user = userRepository.findById(loanBook.getUserId()).orElseThrow(IllegalArgumentException::new);
		Book book = bookRepository.findById(loanBook.getBookId()).orElseThrow(IllegalArgumentException::new);

		book.loaned(user);
		bookRepository.save(book);
	}

	public List<LoanReturnResult> getBooksForReturn() {
		List<BookDto> books = bookConverter.toDtosList(bookRepository.findBooksByAvailableLessThanPurchased());
		List<UserDto> users = userConverter.toDtosList(userRepository.findAll());

		List<LoanReturnResult> loanReturns = books.stream()
				.map(LoanReturnResult::new)
				.collect(Collectors.toList());

		loanReturns.forEach(loanReturn -> loanReturn.setUsers(users.stream()
				.filter(user -> loanReturn.getBook().getUsers().stream().anyMatch(userDto -> userDto.equals(user)))
				.collect(Collectors.toList())));

		return loanReturns;
	}

	public void returnBook(LoanReturnForm returnBook) {
		User user = userRepository.findById(returnBook.getUserId()).orElseThrow(IllegalArgumentException::new);
		Book book = bookRepository.findById(returnBook.getBookId()).orElseThrow(IllegalArgumentException::new);

		book.returned(user);
		bookRepository.save(book);
	}

}

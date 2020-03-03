package com.persado.assignment.project.service;

import com.persado.assignment.project.converter.BookConverter;
import com.persado.assignment.project.model.dto.BookDto;
import com.persado.assignment.project.model.entity.Book;
import com.persado.assignment.project.model.entity.User;
import com.persado.assignment.project.repository.BookRepository;
import com.persado.assignment.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class LoanService {

	private final BookRepository bookRepository;
	private final UserRepository userRepository;
	private final BookConverter bookConverter;

	public void returnBook(BookDto bookDto, UUID userId) {
		Book book = bookConverter.toEntity(bookDto);

		book.getUsers().removeIf(user -> userId.equals(user.getId()));
		book.bookReturned();
		bookRepository.save(book);
	}

	public void loanBook(BookDto bookDto, UUID userId) {
		Book book = bookConverter.toEntity(bookDto);
		User user = userRepository.getOne(userId);

		book.getUsers().add(user);
		book.bookLoaned();
		bookRepository.save(book);

	}

}

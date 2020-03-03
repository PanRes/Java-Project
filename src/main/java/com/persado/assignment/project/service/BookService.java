package com.persado.assignment.project.service;

import com.persado.assignment.project.converter.BookConverter;
import com.persado.assignment.project.model.dto.BookDto;
import com.persado.assignment.project.model.entity.Book;
import com.persado.assignment.project.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.naming.CannotProceedException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BookService {

	private final BookRepository bookRepository;
	private final BookConverter bookConverter;

	public BookDto saveBook(BookDto bookDto) {
		if (bookDto.isNew()) {
			bookDto.setAvailable(bookDto.getPurchased());
		}
		Book book = bookRepository.save(bookConverter.toEntity(bookDto));

		return bookConverter.toDto(book);
	}

	public List<BookDto> getBooks() {
		List<Book> books = bookRepository.findAll();

		return bookConverter.toDtosList(books);
	}

	public void deleteBook(UUID bookId) throws CannotProceedException {
		Book book = bookRepository.findById(bookId).orElseThrow(IllegalArgumentException::new);
		if (!CollectionUtils.isEmpty(book.getUsers())) {
			throw new CannotProceedException("Book is loaned and cannot be deleted");
		}

		bookRepository.delete(book);
	}
}

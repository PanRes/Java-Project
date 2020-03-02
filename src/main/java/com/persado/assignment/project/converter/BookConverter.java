package com.persado.assignment.project.converter;

import com.persado.assignment.project.model.dto.BookDto;
import com.persado.assignment.project.model.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter implements Converter<Book, BookDto> {

	@Override
	public Book toEntity(BookDto book) {
		return Book.builder()
				.name(book.getName())
				.summary(book.getSummary())
				.isbn(book.getIsbn())
				.purchased(book.getPurchased())
				.available(book.getAvailable())
				.build();
	}

	@Override
	public BookDto toDto(Book book) {
		return BookDto.builder()
				.name(book.getName())
				.summary(book.getSummary())
				.isbn(book.getIsbn())
				.purchased(book.getPurchased())
				.available(book.getAvailable())
				.build();
	}
}

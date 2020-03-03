package com.persado.assignment.project.converter;

import com.persado.assignment.project.model.dto.BookDto;
import com.persado.assignment.project.model.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookConverter implements Converter<Book, BookDto> {

	private final UserConverter userConverter;

	@Override
	public Book toEntity(BookDto book) {
		return Book.builder()
				.id(book.getId())
				.name(book.getName())
				.summary(book.getSummary())
				.isbn(book.getIsbn())
				.purchased(book.getPurchased())
				.available(book.getAvailable())
				.users(userConverter.toEntitiesList(book.getUsers()))
				.build();
	}

	@Override
	public BookDto toDto(Book book) {
		return BookDto.builder()
				.id(book.getId())
				.name(book.getName())
				.summary(book.getSummary())
				.isbn(book.getIsbn())
				.purchased(book.getPurchased())
				.available(book.getAvailable())
				.users(userConverter.toDtosList(book.getUsers()))
				.build();
	}
}

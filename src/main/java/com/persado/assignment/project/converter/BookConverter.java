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
	public Book toEntity(BookDto bookDto) {
		Book book = Book.builder()
				.id(bookDto.getId())
				.name(bookDto.getName())
				.summary(bookDto.getSummary())
				.isbn(bookDto.getIsbn())
				.purchased(bookDto.getPurchased())
				.available(bookDto.getAvailable())
				.build();
		if (bookDto.getUsers() != null) {
			book.setUsers(userConverter.toEntitiesList(bookDto.getUsers()));
		}

		return book;
	}

	@Override
	public BookDto toDto(Book book) {
		BookDto bookDto = BookDto.builder()
				.id(book.getId())
				.name(book.getName())
				.summary(book.getSummary())
				.isbn(book.getIsbn())
				.purchased(book.getPurchased())
				.available(book.getAvailable())
				.build();
		if (book.getUsers() != null) {
			bookDto.setUsers(userConverter.toDtosList(book.getUsers()));
		}

		return bookDto;
	}
}

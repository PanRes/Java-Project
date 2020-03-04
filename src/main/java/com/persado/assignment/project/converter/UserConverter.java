package com.persado.assignment.project.converter;

import com.persado.assignment.project.model.dto.BookDto;
import com.persado.assignment.project.model.dto.UserDto;
import com.persado.assignment.project.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserConverter implements Converter<User, UserDto> {

	private final AddressConverter addressConverter;

	@Override
	public User toEntity(UserDto user) {
		return User.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.address(addressConverter.toEntity(user.getAddress()))
				.build();
	}

	@Override
	public UserDto toDto(User user) {
		UserDto userDto = UserDto.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.address(addressConverter.toDto(user.getAddress()))
				.build();

		if (user.getBooks() != null) {
			userDto.setBooks(user.getBooks().stream()
					.map(BookDto::new)
					.collect(Collectors.toList()));
		}
		return userDto;
	}
}

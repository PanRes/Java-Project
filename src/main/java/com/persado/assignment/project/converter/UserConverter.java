package com.persado.assignment.project.converter;

import com.persado.assignment.project.model.dto.UserDto;
import com.persado.assignment.project.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserConverter implements Converter<User, UserDto> {

	private final AddressConverter addressConverter;

	@Override
	public User toEntity(UserDto user) {
		return User.builder()
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.address(addressConverter.toEntity(user.getAddress()))
				.build();
	}

	@Override
	public UserDto toDto(User user) {
		return UserDto.builder()
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.address(addressConverter.toDto(user.getAddress()))
				.build();
	}
}

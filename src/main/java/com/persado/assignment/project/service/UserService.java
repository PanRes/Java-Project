package com.persado.assignment.project.service;

import com.persado.assignment.project.converter.UserConverter;
import com.persado.assignment.project.model.dto.UserDto;
import com.persado.assignment.project.model.entity.User;
import com.persado.assignment.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.naming.CannotProceedException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserConverter userConverter;

	public UserDto saveUser(UserDto userDto) {
		User user = userRepository.save(userConverter.toEntity(userDto));

		return userConverter.toDto(user);
	}

	public List<UserDto> getUsers() {
		List<User> users = userRepository.findAll();

		return userConverter.toDtosList(users);
	}

	public void deleteUser(UUID userId) throws CannotProceedException {
		User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
		if (!CollectionUtils.isEmpty(user.getBooks())) {
			throw new CannotProceedException("User has loaned books and cannot be deleted");
		}

		userRepository.delete(user);
	}
}

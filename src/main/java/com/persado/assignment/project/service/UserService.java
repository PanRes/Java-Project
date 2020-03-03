package com.persado.assignment.project.service;

import com.persado.assignment.project.converter.UserConverter;
import com.persado.assignment.project.exception.UserDeletionException;
import com.persado.assignment.project.model.dto.UserDto;
import com.persado.assignment.project.model.entity.Address;
import com.persado.assignment.project.model.entity.User;
import com.persado.assignment.project.repository.AddressRepository;
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
	private final AddressRepository addressRepository;
	private final UserConverter userConverter;

	public UserDto saveUser(UserDto userDto) {
		User user = userConverter.toEntity(userDto);
		Address address = addressRepository.findAddressByStreetAndHouseNumberAndPostalCodeAndTown(
				user.getAddress().getStreet(), user.getAddress().getHouseNumber(), user.getAddress().getPostalCode(),
				user.getAddress().getTown());
		if (address != null) {
			user.setAddress(address);
		}
		userRepository.save(user);

		return userConverter.toDto(user);
	}

	public List<UserDto> getUsers() {
		List<User> users = userRepository.findAll();

		return userConverter.toDtosList(users);
	}

	public void deleteUser(UUID userId) throws CannotProceedException {
		User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
		if (!CollectionUtils.isEmpty(user.getBooks())) {
			throw new UserDeletionException("User has loaned books and cannot be deleted");
		}

		userRepository.delete(user);
	}

	public UserDto findUserById(UUID userId) {
		User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
		return userConverter.toDto(user);
	}
}

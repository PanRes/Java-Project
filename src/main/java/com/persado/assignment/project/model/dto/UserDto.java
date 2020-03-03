package com.persado.assignment.project.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

	private UUID id;

	@NotBlank(message = "First Name is a mandatory field")
	private String firstName;

	@NotBlank(message = "Last Name is a mandatory field")
	private String lastName;

	private AddressDto address = new AddressDto();

	private List<BookDto> books;

	public boolean isNew() {
		return id == null;
	}

}

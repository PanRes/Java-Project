package com.persado.assignment.project.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass() || this.isNew() || ((UserDto) o).isNew()) {
			return false;
		}
		UserDto userDto = (UserDto) o;
		return Objects.equals(id, userDto.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

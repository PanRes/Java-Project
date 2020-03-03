package com.persado.assignment.project.model.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {

	private UUID id;

	@NotBlank(message = "Street is a mandatory field")
	private String street;

	@Min(value = 1, message = "House Number is a mandatory field")
	private int houseNumber;

	@NotBlank(message = "Postal Code is a mandatory field")
	private String postalCode;

	@NotBlank(message = "Town is a mandatory field")
	private String town;

	private List<UserDto> users;

	public boolean isNew() {
		return id == null;
	}

	@Override
	public String toString() {
		return street + ' ' + houseNumber + ", " + postalCode + ", " + town;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass() || this.isNew() || ((AddressDto) o).isNew()) {
			return false;
		}
		AddressDto addressDto = (AddressDto) o;
		return Objects.equals(id, addressDto.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}

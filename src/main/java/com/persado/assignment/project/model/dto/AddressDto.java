package com.persado.assignment.project.model.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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

	@ToString.Exclude
	private List<UserDto> users;

	public boolean isNew() {
		return id == null;
	}

}

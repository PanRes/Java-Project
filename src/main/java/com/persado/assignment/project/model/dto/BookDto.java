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
@ToString
public class BookDto {

	private UUID id;

	@NotBlank(message = "Book's name is a mandatory field")
	private String name;

	private String summary;

	@NotBlank(message = "ISBN is a mandatory field")
	private String isbn;

	private int purchased;

	private int available;

	@ToString.Exclude
	private List<UserDto> users;

	public boolean isNew() {
		return id == null;
	}


}

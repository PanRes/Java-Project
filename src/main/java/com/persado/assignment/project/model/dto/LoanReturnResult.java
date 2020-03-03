package com.persado.assignment.project.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class LoanReturnResult {

	private BookDto book;
	private List<UserDto> users;

	public LoanReturnResult(BookDto book) {
		this.book = book;
	}
}

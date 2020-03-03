package com.persado.assignment.project.model.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanReturnForm {

	private UUID bookId;
	private UUID userId;

}

package com.persado.assignment.project.enums;

import lombok.Getter;

@Getter
public enum LoanReturnPath {

	LOAN("loan"),
	RETURN_BOOK("returnBook");

	private String path;

	LoanReturnPath(String path) {
		this.path = path;
	}

}

package com.persado.assignment.project.exception;

import lombok.NoArgsConstructor;

import javax.naming.CannotProceedException;

@NoArgsConstructor
public class UserDeletionException extends CannotProceedException {

	public UserDeletionException(String explanation) {
		super(explanation);
	}

}

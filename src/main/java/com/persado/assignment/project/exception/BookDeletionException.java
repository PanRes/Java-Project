package com.persado.assignment.project.exception;

import lombok.NoArgsConstructor;

import javax.naming.CannotProceedException;

@NoArgsConstructor
public class BookDeletionException extends CannotProceedException {

	public BookDeletionException(String explanation) {
		super(explanation);
	}

}

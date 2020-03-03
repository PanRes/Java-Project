package com.persado.assignment.project.model.dto;

import com.persado.assignment.project.enums.LoanReturnPath;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static com.persado.assignment.project.enums.LoanReturnPath.LOAN;

@Getter
@Setter
@EqualsAndHashCode
public class LoanReturnForm {

	private UUID bookId;
	private UUID userId;
	private LoanReturnPath loanReturnPath;

	public LoanReturnForm(LoanReturnPath loanReturnPath) {
		this.loanReturnPath = loanReturnPath;
	}

	public boolean isLoan() {
		return LOAN.equals(loanReturnPath);
	}
}

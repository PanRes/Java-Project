package com.persado.assignment.project.model.dto;

import com.persado.assignment.project.model.entity.Book;
import lombok.*;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BookDto {

	@EqualsAndHashCode.Include
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

	public BookDto(Book book) {
		this.id = book.getId();
		this.name = book.getName();
		this.summary = book.getSummary();
		this.isbn = book.getIsbn();
		this.purchased = book.getPurchased();
		this.available = book.getAvailable();
	}

	public boolean isNew() {
		return id == null;
	}

	public int onLoan() {
		return purchased - available;
	}

	public String getUsersInLine() {
		if (CollectionUtils.isEmpty(users)) {
			return "";
		}

		List<String> userNames = users.stream()
				.map(UserDto::getFirstName)
				.collect(Collectors.toList());
		return ", loaned By " + String.join(", ", userNames);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass() || this.isNew() || ((BookDto) o).isNew()) {
			return false;
		}
		BookDto bookDto = (BookDto) o;
		return Objects.equals(id, bookDto.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}

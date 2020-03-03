package com.persado.assignment.project.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(
		name="book",
		uniqueConstraints=@UniqueConstraint(name = "book_name_isbn", columnNames={"name", "isbn"}),
		schema = "persado"
)
public class Book extends PersistableEntity{

	@Column(nullable = false)
	private String name;

	@Column(length = 2000, nullable = false)
	private String summary;

	@Column(name = "isbn", nullable = false, unique = true)
	private String isbn;

	@Column
	private int purchased;

	@Column
	private int available;

	@ToString.Exclude
	@ManyToMany
	@JoinTable(name = "user_book",
			joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false))
	private List<User> users;

	@Builder
	public Book(UUID id, String name, String summary, String isbn, int purchased, int available, List<User> users) {
		this.id = id;
		this.name = name;
		this.summary = summary;
		this.isbn = isbn;
		this.purchased = purchased;
		this.available = available;
		this.users = users;
	}

	public void bookReturned() {
		if (available < purchased) {
			available++;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public void bookLoaned() {
		if (available > 0) {
			available--;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

}

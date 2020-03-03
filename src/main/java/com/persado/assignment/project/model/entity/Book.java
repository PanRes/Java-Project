package com.persado.assignment.project.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

import static javax.persistence.FetchType.EAGER;

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
	@ManyToMany(fetch = EAGER)
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

	public void returned(User user) {
		if (available < purchased) {
			available++;
			users.removeIf(u -> u.equals(user));
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public void loaned(User user) {
		if (available > 0) {
			available--;
			users.add(user);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

}

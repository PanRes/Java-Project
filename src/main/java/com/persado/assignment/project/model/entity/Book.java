package com.persado.assignment.project.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

	public void bookReturned() {
		if (available < purchased) {
			available++;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public void bookPurchased() {
		purchased++;
		available++;
	}

}

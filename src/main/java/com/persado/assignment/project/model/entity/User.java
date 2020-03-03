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
		name = "\"user\"",
		uniqueConstraints=@UniqueConstraint(name = "full_name_address_index", columnNames={"first_name", "last_name", "address_id"}),
		schema = "persado"
)
public class User extends PersistableEntity {

	@Column(name = "first_name", length = 100, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 100, nullable = false)
	private String lastName;

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
	private Address address;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_book",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false))
	private List<Book> books;

	@Builder
	public User(UUID id, String firstName, String lastName, Address address, List<Book> books) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.books = books;
	}

}

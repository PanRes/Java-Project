package com.persado.assignment.project.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@Entity
@Table(
		name = "\"user\"",
		uniqueConstraints=@UniqueConstraint(name = "full_name_address_index", columnNames={"first_name", "last_name", "address_id"}),
		schema = "persado"
)
public class User extends PersistableEntity {

	@NotBlank
	@Column(name = "first_name", length = 100, nullable = false)
	private String firstName;

	@NotBlank
	@Column(name = "last_name", length = 100, nullable = false)
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
	private Address address;

	@ManyToMany
	@JoinTable(name = "user_book",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false))
	private List<Book> books;

}

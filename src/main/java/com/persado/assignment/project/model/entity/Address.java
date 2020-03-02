package com.persado.assignment.project.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
		name = "address",
		uniqueConstraints = @UniqueConstraint(name = "full_address_index", columnNames = {"street", "house_number", "postal_code", "town"}),
		schema = "persado"
)
public class Address extends PersistableEntity {

	@NotBlank
	@Column(length = 100, nullable = false)
	private String street;

	@Min(1)
	@Column(name = "house_number", nullable = false)
	private int houseNumber;

	@NotBlank
	@Column(name = "postal_code", length = 10, nullable = false)
	private String postalCode;

	@NotBlank
	@Column(length = 100, nullable = false)
	private String town;

	@ToString.Exclude
	@OneToMany(mappedBy = "address")
	private List<User> users;

}

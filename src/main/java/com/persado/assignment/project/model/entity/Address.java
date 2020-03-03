package com.persado.assignment.project.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

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

	@Column(length = 100, nullable = false)
	private String street;

	@Column(name = "house_number", nullable = false)
	private int houseNumber;

	@Column(name = "postal_code", length = 10, nullable = false)
	private String postalCode;

	@Column(length = 100, nullable = false)
	private String town;

	@ToString.Exclude
	@OneToMany(mappedBy = "address")
	private List<User> users;

	@Builder
	public Address(UUID id, String street, int houseNumber, String postalCode, String town, List<User> users) {
		this.id = id;
		this.street = street;
		this.houseNumber = houseNumber;
		this.postalCode = postalCode;
		this.town = town;
		this.users = users;
	}
}

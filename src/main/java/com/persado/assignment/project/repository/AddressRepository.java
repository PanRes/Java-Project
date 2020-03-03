package com.persado.assignment.project.repository;

import com.persado.assignment.project.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

	Address findAddressByStreetAndHouseNumberAndPostalCodeAndTown(String street, int houseNumer, String postalCode,
																  String town);
}

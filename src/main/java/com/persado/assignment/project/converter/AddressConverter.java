package com.persado.assignment.project.converter;

import com.persado.assignment.project.model.dto.AddressDto;
import com.persado.assignment.project.model.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter implements Converter<Address, AddressDto> {

	public Address toEntity(AddressDto address) {
		return Address.builder()
				.street(address.getStreet())
				.houseNumber(address.getHouseNumber())
				.postalCode(address.getPostalCode())
				.town(address.getTown())
				.build();
	}

	public AddressDto toDto(Address address) {
		return AddressDto.builder()
				.street(address.getStreet())
				.houseNumber(address.getHouseNumber())
				.postalCode(address.getPostalCode())
				.town(address.getTown())
				.build();
	}
}

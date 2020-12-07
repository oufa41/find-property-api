package com.example.find.property.mapper;

import org.springframework.stereotype.Component;

import com.example.find.property.dto.AddressDtoV1;
import com.example.find.property.model.Address;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author aabdelraouf
 *
 */
@Component
@RequiredArgsConstructor
public class AddressMapperV1 implements EntityMapper<AddressDtoV1, Address> {

	/**
	 * 
	 * @param address entity
	 * @return DTO address after mapped
	 */
	@Override
	public AddressDtoV1 toDto(Address entity) {
		AddressDtoV1 dto = new AddressDtoV1();
		dto.setCity(entity.getCity());
		dto.setCountry(entity.getCountry());
		dto.setFlatNumber(entity.getFlatNumber());
		dto.setHouseNumber(entity.getHouseNumber());
		dto.setLatitude(entity.getLatitude());
		dto.setLongitude(entity.getLongitude());
		dto.setStreetName(entity.getStreetName());
		dto.setTown(entity.getTown());
		return dto;
	}

	/**
	 * 
	 * @param address DTO
	 * @return entity address after mapped
	 */
	@Override
	public Address toEntity(AddressDtoV1 dto) {

		Address entity = new Address();
		entity.setCity(dto.getCity());
		entity.setCountry(dto.getCountry());
		entity.setFlatNumber(dto.getFlatNumber());
		entity.setHouseNumber(dto.getHouseNumber());
		entity.setLatitude(dto.getLatitude());
		entity.setLongitude(dto.getLongitude());
		entity.setStreetName(dto.getStreetName());
		entity.setTown(dto.getTown());
		return entity;
	}

}

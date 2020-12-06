package com.example.find.property.mapper;

import org.springframework.stereotype.Component;

import com.example.find.property.domain.Property;
import com.example.find.property.dto.PropertyDtoV1;

import lombok.RequiredArgsConstructor;


/**
 * 
 * @author aabdelraouf
 *
 */
@Component
@RequiredArgsConstructor
public class PropertyMapperV1 implements EntityMapper<PropertyDtoV1, Property> {

	
	/**
	 * 
	 * @param property entity
	 * @return DTO property after mapped 
	 */
	@Override
	public PropertyDtoV1 toDto(Property entity) {
		PropertyDtoV1 dto = new PropertyDtoV1();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setAddress(entity.getAddress());
		return dto;
	}

	
	/**
	 * 
	 * @param property DTO
	 * @return entity property after mapped 
	 */
	@Override
	public Property toEntity(PropertyDtoV1 dto) {
		Property entity = new Property();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		return entity;
	}

}

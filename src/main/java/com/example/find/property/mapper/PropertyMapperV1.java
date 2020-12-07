package com.example.find.property.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.find.property.dto.AddressDtoV1;
import com.example.find.property.dto.AgentDtoV1;
import com.example.find.property.dto.PropertyDtoV1;
import com.example.find.property.model.Address;
import com.example.find.property.model.Agent;
import com.example.find.property.model.Property;

import lombok.RequiredArgsConstructor;


/**
 * 
 * @author aabdelraouf
 *
 */
@Component
@RequiredArgsConstructor
public class PropertyMapperV1 implements EntityMapper<PropertyDtoV1, Property> {

	@Autowired
	public EntityMapper<AddressDtoV1, Address> addressMapper;
	
	@Autowired
	public EntityMapper<AgentDtoV1, Agent> agentMapper;
	
	
	/**
	 * 
	 * @param property entity
	 * @return DTO property after mapped 
	 */
	@Override
	public PropertyDtoV1 toDto(Property entity) {
		PropertyDtoV1 dto = new PropertyDtoV1();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setSellingType(entity.getSellingType());
		dto.setPrice(entity.getPrice());
		dto.setSize(entity.getSize());
		dto.setAddress(addressMapper.toDto(entity.getAddress()));
		dto.setAgent(agentMapper.toDto(entity.getAgent()));
		dto.setPhotos(entity.getPhotos());
		dto.setAmenities(entity.getAmenities());
		dto.setNumberBedrooms(entity.getNumberBedrooms());
		dto.setNumberBathrooms(entity.getNumberBathrooms());
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
		entity.setTitle(dto.getTitle());
		entity.setSellingType(dto.getSellingType());
		entity.setPrice(dto.getPrice());
		entity.setSize(dto.getSize());
		entity.setAddress(addressMapper.toEntity(dto.getAddress()));
		entity.setPhotos(dto.getPhotos());
		entity.setAgent(agentMapper.toEntity(dto.getAgent()));
		entity.setAmenities(dto.getAmenities());
		entity.setNumberBedrooms(dto.getNumberBedrooms());
		entity.setNumberBathrooms(dto.getNumberBathrooms());
		return entity;
	}

}

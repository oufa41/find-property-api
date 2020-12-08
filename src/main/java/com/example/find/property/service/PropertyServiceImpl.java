package com.example.find.property.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.find.property.dto.AddressDtoV1;
import com.example.find.property.dto.PropertyDtoV1;
import com.example.find.property.exceptions.RecordNotFoundException;
import com.example.find.property.mapper.EntityMapper;
import com.example.find.property.model.Address;
import com.example.find.property.model.Property;
import com.example.find.property.model.SellingType;
import com.example.find.property.repository.PropertyRepository;

/**
 * 
 * @author aabdelraouf
 *
 */
@Service
public class PropertyServiceImpl implements PropertyService {

	private static final String NOT_FOUND_MESSAGE = "Property with id = %s not found";

	@Autowired
	public PropertyRepository propertyRepository;

	@Autowired
	public EntityMapper<PropertyDtoV1, Property> propertyMapper;

	@Autowired
	public EntityMapper<AddressDtoV1, Address> addressMapper;

	@Override
	public PropertyDtoV1 createProperty(PropertyDtoV1 property) {
		Property entity = propertyMapper.toEntity(property);
		entity = propertyRepository.save(entity);
		return propertyMapper.toDto(entity);
	}

	@Override
	public List<PropertyDtoV1> getAllProperties(String addressKeyword, SellingType type, String title) {

		if (StringUtils.isNotBlank(addressKeyword) && type != null) {
			return propertyMapper.toDto(propertyRepository.findByAddressAndSellingType(addressKeyword, type));
		} else if (StringUtils.isNotBlank(addressKeyword)) {
			return propertyMapper.toDto(propertyRepository.findByAddress(addressKeyword));
		} else if (type != null) {
			return propertyMapper.toDto(propertyRepository.findBySellingType(type));
		} else {
			return propertyMapper.toDto(propertyRepository.findAll());
		}

	}

	@Override
	public PropertyDtoV1 getProperty(final int id) {
		Optional<Property> propertyModel = propertyRepository.findById(id);
		if (propertyModel.isPresent()) {
			return propertyMapper.toDto(propertyModel.get());
		} else {
			throw new RecordNotFoundException(String.format(NOT_FOUND_MESSAGE, id));
		}
	}

	@Override
	public PropertyDtoV1 updatePropertyDtoV1(final int id, PropertyDtoV1 property) {

		if (propertyRepository.findById(id).isPresent()) {
			Property propertyModel = propertyRepository.save(propertyMapper.toEntity(property));
			return propertyMapper.toDto(propertyModel);
		} else {
			throw new RecordNotFoundException(String.format(NOT_FOUND_MESSAGE, id));
		}

	}

	@Override
	public void deleteProperty(int id) {
		if (propertyRepository.findById(id).isPresent()) {
			propertyRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException(String.format(NOT_FOUND_MESSAGE, id));
		}

	}

}

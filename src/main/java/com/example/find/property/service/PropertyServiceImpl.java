package com.example.find.property.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.find.property.domain.Property;
import com.example.find.property.dto.PropertyDtoV1;
import com.example.find.property.exceptions.RecordNotFoundException;
import com.example.find.property.mapper.EntityMapper;
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

	@Override
	public PropertyDtoV1 createProperty(PropertyDtoV1 property) {
		Property entity = propertyMapper.toEntity(property);
		entity = propertyRepository.save(entity);
		return propertyMapper.toDto(entity);
	}

	@Override
	public List<PropertyDtoV1> getAllProperties() {
		List<Property> properties = propertyRepository.findAll();
		return propertyMapper.toDto(properties);
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